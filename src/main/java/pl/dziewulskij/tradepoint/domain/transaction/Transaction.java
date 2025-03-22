package pl.dziewulskij.tradepoint.domain.transaction;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommand;
import pl.dziewulskij.tradepoint.domain.audit.TimeAuditable;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.time.LocalDateTime;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "TRANSACTION",
        indexes = @Index(name = "idx_transaction_business_id", columnList = "business_id", unique = true)
)
public class Transaction extends TimeAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    @Builder.Default
    BusinessId businessId = new BusinessId();

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", length = 15)
    TransactionType transactionType;

    @Column(name = "transaction_date")
    LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", length = 15)
    PaymentType paymentType;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", length = 20)
    PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    @Embedded
    TransactionTotal total;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    public void update(TransactionCommand command, Customer customer, Product product) {
        this.paymentType = command.paymentType();
        this.paymentStatus = command.paymentStatus();
        this.total = new TransactionTotal(command.price(), command.quantity());
        this.customer = customer;
        this.product = product;
    }
}
