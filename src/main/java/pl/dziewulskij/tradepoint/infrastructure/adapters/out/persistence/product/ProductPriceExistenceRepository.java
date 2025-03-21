package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductPriceExistencePort;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Repository
@RequiredArgsConstructor
public class ProductPriceExistenceRepository implements ProductPriceExistencePort {

    private final ProductPriceJpaRepository productPriceJpaRepository;

    @Override
    public boolean existsByIdAndUserId(BusinessId priceId, BusinessId userId) {
        return productPriceJpaRepository.existsByBusinessIdAndProductUserBusinessId(priceId, userId);
    }
}
