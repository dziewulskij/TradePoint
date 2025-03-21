package pl.dziewulskij.tradepoint.application.port.in.product.command.price;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface ProductPriceCommandUseCase {

    ProductPriceResult create(CreateProductPriceCommand command);

}
