package pl.dziewulskij.tradepoint.application.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.out.transaction.DeleteTransactionPort;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.application.transaction.mapper.TransactionMapper;
import pl.dziewulskij.tradepoint.application.transaction.validator.TransactionValidatorFacade;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionFactory;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class TransactionCommandService implements TransactionCommandUseCase {

    private final SaveTransactionPort saveTransactionPort;
    private final DeleteTransactionPort deleteTransactionPort;
    private final TransactionMapper transactionMapper;
    private final TransactionFactory transactionFactory;
    private final TransactionCommandProviderFacade commandProviderFacade;
    private final TransactionValidatorFacade commandValidatorFacade;
    private final TransactionUndoManager transactionUndoManager;

    @Override
    @Transactional
    public TransactionResult create(TransactionCommand command) {
        commandValidatorFacade.validateForCreationOrUpdate(command);

        User user = commandProviderFacade.currentUser();
        Customer customer = commandProviderFacade.customerByBusinessId(command.customerId());
        Product product = commandProviderFacade.productByBusinessId(command.productId());
        Transaction transaction = transactionFactory.createFrom(command, user, customer, product);

        saveTransactionPort.save(transaction);
        return transactionMapper.toResult(transaction);
    }

    @Override
    @Transactional
    public TransactionResult update(BusinessId transactionId, TransactionCommand command) {
        commandValidatorFacade.validateForCreationOrUpdate(command);

        Transaction transaction = commandProviderFacade.transactionByBusinessId(transactionId);
        Customer customer = commandProviderFacade.customerByBusinessId(command.customerId());
        Product product = commandProviderFacade.productByBusinessId(command.productId());
        transaction.update(command, customer, product);

        transactionUndoManager.saveState(transaction);
        saveTransactionPort.save(transaction);
        return transactionMapper.toResult(transaction);
    }

    @Override
    @Transactional
    public void delete(BusinessId transactionId) {
        commandValidatorFacade.validateForDeletion(transactionId);
        deleteTransactionPort.deleteById(transactionId);
    }

    @Override
    @Transactional
    public void undoLastChange(BusinessId transactionId) {
        Transaction transaction = commandProviderFacade.transactionByBusinessId(transactionId);
        transactionUndoManager.undo(transaction);
        saveTransactionPort.save(transaction);
    }

}
