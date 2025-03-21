package pl.dziewulskij.tradepoint.application.port.in.product.command;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface ProductCommandUseCase {

    CreateProductResult create(CreateProductCommand command);

    void delete(BusinessId productId);

}
