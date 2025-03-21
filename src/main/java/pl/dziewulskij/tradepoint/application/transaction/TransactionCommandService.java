package pl.dziewulskij.tradepoint.application.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.provider.CustomerProvider;
import pl.dziewulskij.tradepoint.application.customer.validator.CustomerBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.port.in.transaction.CreateTransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.application.product.service.ProductProvider;
import pl.dziewulskij.tradepoint.application.product.validator.ProductBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionFactory;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class TransactionCommandService implements TransactionCommandUseCase {

    private final SaveTransactionPort saveTransactionPort;
    private final TransactionMapper transactionMapper;
    private final TransactionFactory transactionFactory;
    private final UserProvider userProvider;
    private final CustomerProvider<Customer> customerProvider;
    private final ProductProvider productProvider;
    private final CustomerBelongToUserValidator customerBelongToUserValidator;
    private final ProductBelongToUserValidator productBelongToUserValidator;

    @Override
    @Transactional
    public TransactionResult create(CreateTransactionCommand command) {
        customerBelongToUserValidator.validate(command.customerId());
        productBelongToUserValidator.validate(command.productId());

        User user = userProvider.currentUser();
        Customer customer = customerProvider.byBusinessId(command.customerId());
        Product product = productProvider.byBusinessId(command.productId());
        Transaction transaction = transactionFactory.createFrom(command, user, customer, product);

        saveTransactionPort.save(transaction);
        return transactionMapper.toResult(transaction);
    }
}
