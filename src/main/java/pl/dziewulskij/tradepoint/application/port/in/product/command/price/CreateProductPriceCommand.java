package pl.dziewulskij.tradepoint.application.port.in.product.command.price;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateProductPriceCommand(
        BusinessId productId,
        BigDecimal price,
        LocalDate validFrom
) {
}
