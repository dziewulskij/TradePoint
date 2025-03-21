package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface ProductExistencePort {

    boolean existsByIdAndUserId(BusinessId productId, BusinessId userId);

    boolean existsByNameAndUserId(String name, BusinessId userId);

    boolean existsByNameAndUserIdExcludingProductId(String name, BusinessId userId, BusinessId productId);

}
