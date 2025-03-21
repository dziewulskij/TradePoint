package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface ProductPriceExistencePort {

    boolean existsByIdAndUserId(BusinessId priceId, BusinessId userId);

}
