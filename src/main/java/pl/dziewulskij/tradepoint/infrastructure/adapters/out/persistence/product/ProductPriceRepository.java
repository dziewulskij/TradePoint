package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.product.LoadProductPricePort;
import pl.dziewulskij.tradepoint.application.port.out.product.RemoveProductPricePort;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPricePort;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductPriceRepository implements LoadProductPricePort, SaveProductPricePort, RemoveProductPricePort {

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
    public void deleteByBusinessId(BusinessId productPriceId) {
        productPriceJpaRepository.deleteByBusinessId(productPriceId);
    }
}
