package pl.dziewulskij.tradepoint.domain.transaction.info;

import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

import java.time.LocalDateTime;

public interface TransactionOverviewInfo {

    BusinessId getId();

    String getProductName();

    String getProductUnit();

    String getCustomerFirstName();

    String getCustomerLastName();

    String getCustomerCompanyName();

    CustomerType getCustomerType();

    TransactionType getTransactionType();

    PaymentType getPaymentType();

    PaymentStatus getPaymentStatus();

    TransactionTotal getTotal();

    LocalDateTime getTransactionDate();

    default String getCustomerName() {
        return switch (getCustomerType()) {
            case PERSON -> getCustomerFirstName() + " " + getCustomerLastName();
            case COMPANY -> getCustomerCompanyName();
        };
    }

}
