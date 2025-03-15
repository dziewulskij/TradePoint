package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

public interface ProductExistencePort {

    boolean existsByNameAndUserId(String name, BusinessId userId);

    boolean existsByNameAndUserIdExcludingProductId(String name, BusinessId userId, BusinessId productId);

}
