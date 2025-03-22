package pl.dziewulskij.tradepoint.application.port.out.product.price;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface DeleteProductPricePort {

    void deleteById(BusinessId productPriceId);

}
