package pl.dziewulskij.tradepoint.application.port.in.product.query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GetProductResult(
        UUID id,
        String name,
        String unit,
        BigDecimal newestPrice,
        LocalDate priceSetOnDay
) {
}
