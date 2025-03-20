package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface LoadProductPort {

    List<Product> findAllByUserId(BusinessId userId);

    Optional<Product> findByBusinessId(BusinessId businessId);

}
