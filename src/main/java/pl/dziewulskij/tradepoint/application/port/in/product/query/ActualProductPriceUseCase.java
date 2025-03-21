package pl.dziewulskij.tradepoint.application.port.in.product.query;

import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface ActualProductPriceUseCase {

    ProductPriceResult getActualProductPrice(BusinessId productId);

}
