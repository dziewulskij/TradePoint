package pl.dziewulskij.tradepoint.domain.transaction;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommand;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.time.LocalDateTime;

@Component
public class TransactionFactory {

    public Transaction createFrom(TransactionCommand command, User user, Customer customer, Product product) {
        TransactionTotal total = new TransactionTotal(command.price(), command.quantity());

        return Transaction.builder()
                .transactionType(TransactionType.BUY)
                .transactionDate(LocalDateTime.now())
                .paymentType(command.paymentType())
                .paymentStatus(command.paymentStatus())
                .total(total)
                .user(user)
                .customer(customer)
                .product(product)
                .build();
    }

}
