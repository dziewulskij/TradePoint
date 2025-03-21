package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface LoadProductPricePort {

    List<ProductPrice> findAllByProductId(BusinessId productId);

    Optional<ProductPrice> findActualProductPrice(BusinessId productId);

}
