package pl.dziewulskij.tradepoint.application.port.in.transaction.command;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

public record TransactionResult(
        BusinessId id,
        String productName,
        String unit,
        TransactionType transactionType,
        PaymentType paymentType,
        PaymentStatus paymentStatus,
        TransactionTotal total,
        BusinessId customerId,
        BusinessId productId
) {
}
