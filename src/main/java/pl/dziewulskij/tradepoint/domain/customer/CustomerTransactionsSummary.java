package pl.dziewulskij.tradepoint.domain.customer;

import java.math.BigDecimal;

public record CustomerTransactionsSummary(
        BigDecimal buyTotal,
        BigDecimal sellTotal
) {

    public static CustomerTransactionsSummary empty() {
        return new CustomerTransactionsSummary(BigDecimal.ZERO, BigDecimal.ZERO);
    }

}
