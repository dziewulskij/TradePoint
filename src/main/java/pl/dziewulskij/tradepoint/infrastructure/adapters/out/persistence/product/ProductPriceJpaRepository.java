package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductPriceJpaRepository extends JpaRepository<ProductPrice, Long> {

    List<ProductPrice> findByProductBusinessIdOrderByValidFromDescIdDesc(BusinessId businessId);

    @Query("""
            select pp from ProductPrice pp
                where pp.product.businessId = :productId and pp.validFrom <= :untilDate
                order by pp.validFrom desc, pp.id desc
                limit 1
            """)
    Optional<ProductPrice> findNewestByProductBusinessIdAndData(BusinessId productId, LocalDate untilDate);

    void deleteByBusinessId(BusinessId businessId);

    boolean existsByBusinessIdAndProductUserBusinessId(BusinessId businessId, BusinessId businessId1);
}
