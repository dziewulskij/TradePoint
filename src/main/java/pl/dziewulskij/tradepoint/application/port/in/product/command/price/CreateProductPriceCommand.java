package pl.dziewulskij.tradepoint.application.port.in.product.command.price;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Price;

import java.time.LocalDate;

public record CreateProductPriceCommand(
        BusinessId productId,
        Price price,
        LocalDate validFrom
) {
}
