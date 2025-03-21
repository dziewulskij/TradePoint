package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    List<Product> findByUserBusinessId(BusinessId businessId);

    Optional<Product> findByBusinessId(BusinessId businessId);

    boolean existsByNameAndUserBusinessIdAndBusinessIdNot(String name, BusinessId businessId, BusinessId businessId1);

    boolean existsByNameAndUserBusinessId(String name, BusinessId businessId);

    boolean existsByBusinessIdAndUserBusinessId(BusinessId businessId, BusinessId businessId1);
}
