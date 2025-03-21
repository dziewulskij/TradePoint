package pl.dziewulskij.tradepoint.application.port.in.product.query;

import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

import java.util.List;

@InputPort
public interface ProductPriceQueryUseCase {

    List<ProductPriceResult> getAllByProductId(BusinessId productId);

}
