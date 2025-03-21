package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.product.LoadProductPort;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductExistencePort;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPort;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements SaveProductPort, LoadProductPort, ProductExistencePort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public List<Product> findAllByUserId(BusinessId userId) {
        return productJpaRepository.findByUserBusinessId(userId);
    }

    @Override
    public Optional<Product> findByBusinessId(BusinessId productId) {
        return productJpaRepository.findByBusinessId(productId);
    }

    @Override
    public boolean existsByIdAndUserId(BusinessId productId, BusinessId userId) {
        return productJpaRepository.existsByBusinessIdAndUserBusinessId(productId, userId);
    }

    @Override
    public boolean existsByNameAndUserId(String name, BusinessId userId) {
        return productJpaRepository.existsByNameAndUserBusinessId(name, userId);
    }

    @Override
    public boolean existsByNameAndUserIdExcludingProductId(String name, BusinessId userId, BusinessId productId) {
        return productJpaRepository.existsByNameAndUserBusinessIdAndBusinessIdNot(name, userId, productId);
    }
}
