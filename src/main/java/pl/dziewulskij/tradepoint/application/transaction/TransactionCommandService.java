package pl.dziewulskij.tradepoint.application.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.validator.CustomerBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.application.product.validator.ProductBelongToUserValidator;
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
    private final TransactionMapper transactionMapper;
    private final TransactionFactory transactionFactory;
    private final TransactionCommandProviderFacade commandProviderFacade;
    private final CustomerBelongToUserValidator customerBelongToUserValidator;
    private final ProductBelongToUserValidator productBelongToUserValidator;

    @Override
    @Transactional
    public TransactionResult create(TransactionCommand command) {
        belongToUserValidator(command);

        User user = commandProviderFacade.currentUser();
        Customer customer = commandProviderFacade.customerByBusinessId(command.customerId());
        Product product = commandProviderFacade.productByBusinessId(command.productId());
        Transaction transaction = transactionFactory.createFrom(command, user, customer, product);

        saveTransactionPort.save(transaction);
        return transactionMapper.toResult(transaction);
    }

    @Override
    public TransactionResult update(BusinessId transactionId, TransactionCommand command) {
        belongToUserValidator(command);

        Transaction transaction = commandProviderFacade.transactionByBusinessId(transactionId);
        Customer customer = commandProviderFacade.customerByBusinessId(command.customerId());
        Product product = commandProviderFacade.productByBusinessId(command.productId());
        transaction.update(command, customer, product);

        saveTransactionPort.save(transaction);
        return transactionMapper.toResult(transaction);
    }

    private void belongToUserValidator(TransactionCommand command) {
        customerBelongToUserValidator.validate(command.customerId());
        productBelongToUserValidator.validate(command.productId());
    }
}
