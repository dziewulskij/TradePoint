package pl.dziewulskij.tradepoint.application.port.in.transaction.query;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

public record GetTransactionProductResult(
        BusinessId id,
        String name,
        String unit
) {
}
