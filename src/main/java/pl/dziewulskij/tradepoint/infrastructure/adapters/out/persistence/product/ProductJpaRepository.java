package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    List<Product> findByUserBusinessId(BusinessId userId);

    Optional<Product> findByBusinessId(BusinessId productId);

    boolean existsByNameAndUserBusinessId(String name, BusinessId userId);

    boolean existsByBusinessIdAndUserBusinessId(BusinessId productId, BusinessId userId);

    void deleteByBusinessId(BusinessId productId);

}
