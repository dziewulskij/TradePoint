package pl.dziewulskij.tradepoint.application.port.in.transaction.query;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

import java.time.LocalDateTime;

public record GetTransactionResult(
        BusinessId id,
        TransactionType transactionType,
        PaymentType paymentType,
        PaymentStatus paymentStatus,
        TransactionTotal total,
        LocalDateTime transactionDate,
        GetTransactionCustomerResult customer,
        GetTransactionProductResult product
) {
}
