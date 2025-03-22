package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductPriceExistencePort;
import pl.dziewulskij.tradepoint.application.port.out.product.price.DeleteProductPricePort;
import pl.dziewulskij.tradepoint.application.port.out.product.price.LoadProductPricePort;
import pl.dziewulskij.tradepoint.application.port.out.product.price.SaveProductPricePort;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@OutputAdapter
@Repository
@RequiredArgsConstructor
public class ProductPriceRepositoryAdapter implements
        LoadProductPricePort,
        SaveProductPricePort,
        DeleteProductPricePort,
        ProductPriceExistencePort {

    private final ProductPriceJpaRepository productPriceJpaRepository;

    @Override
    public void save(ProductPrice productPrice) {
        productPriceJpaRepository.save(productPrice);
    }

    @Override
    public List<ProductPrice> findAllByProductId(BusinessId productId) {
        return productPriceJpaRepository.findByProductBusinessId(productId);
    }

    @Override
    public Optional<ProductPrice> findActualProductPrice(BusinessId productId) {
        return productPriceJpaRepository.findNewestByProductBusinessIdAndData(productId, LocalDate.now());
    }

    @Override
    public void deleteById(BusinessId productPriceId) {
        productPriceJpaRepository.deleteByBusinessId(productPriceId);
    }

    @Override
    public boolean existsByIdAndUserId(BusinessId priceId, BusinessId userId) {
        return productPriceJpaRepository.existsByBusinessIdAndProductUserBusinessId(priceId, userId);
    }
}
