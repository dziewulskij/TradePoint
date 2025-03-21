package pl.dziewulskij.tradepoint.application.port.in.product.command.price;

import pl.dziewulskij.tradepoint.domain.product.ProductPriceWithProductIds;

public record DeleteProductPriceCommand(ProductPriceWithProductIds productPriceWithProductIds) {

}
