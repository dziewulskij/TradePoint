package pl.dziewulskij.tradepoint.application.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.customer.provider.CustomerProvider;
import pl.dziewulskij.tradepoint.application.product.service.ProductProvider;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.user.User;

@Component
@RequiredArgsConstructor
public class TransactionCommandProviderFacade {

    private final UserProvider userProvider;
    private final ProductProvider productProvider;
    private final CustomerProvider<Customer> customerProvider;
    private final TransactionProvider transactionProvider;

    public User currentUser() {
        return userProvider.currentUser();
    }

    public Product productByBusinessId(BusinessId productId) {
        return productProvider.byBusinessId(productId);
    }

    public Customer customerByBusinessId(BusinessId customerId) {
        return customerProvider.byBusinessId(customerId);
    }

    public Transaction transactionByBusinessId(BusinessId transactionId) {
        return transactionProvider.byBusinessId(transactionId);
    }

}
