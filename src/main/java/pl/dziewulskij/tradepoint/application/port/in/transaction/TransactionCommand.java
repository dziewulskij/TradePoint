package pl.dziewulskij.tradepoint.application.port.in.transaction;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Price;
import pl.dziewulskij.tradepoint.domain.shared.Quantity;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;

public record TransactionCommand(
        PaymentType paymentType,
        PaymentStatus paymentStatus,
        Quantity quantity,
        Price price,
        BusinessId customerId,
        BusinessId productId
) {
}
