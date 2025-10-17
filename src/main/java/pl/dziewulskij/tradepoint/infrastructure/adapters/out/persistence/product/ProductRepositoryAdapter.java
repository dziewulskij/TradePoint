package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.product.*;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.product.ProductInfo;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction.TransactionJpaRepository;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@OutputAdapter
@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements
        SaveProductPort,
        LoadProductPort,
        ProductExistencePort,
        DeleteProductPort,
        ProductAttachedToTransactionPort {

    private final ProductJpaRepository productJpaRepository;
    private final TransactionJpaRepository transactionJpaRepository;

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public List<ProductInfo> findAllWithNewestPriceByUserId(BusinessId userId) {
        return productJpaRepository.findAllWithNewestPriceByUserBusinessId(userId.getValue(), LocalDate.now());
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
    public void deleteById(BusinessId productId) {
        productJpaRepository.deleteByBusinessId(productId);
    }

    @Override
    public boolean isProductAttachedToAnyTransaction(BusinessId productId) {
        return transactionJpaRepository.existsByProductBusinessId(productId);
    }
}
