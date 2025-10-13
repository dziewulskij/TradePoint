package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.product.ProductInfo;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByBusinessId(BusinessId productId);

    @Query(value = """
            SELECT
                p.business_id       AS businessId,
                p.name              AS name,
                p.unit              AS unit,
                sub.price           AS newestPrice,
                sub.valid_from      AS priceSetOnDay
            FROM product p
            JOIN users u ON p.user_id = u.id
            LEFT JOIN (
                SELECT *
                FROM (
                    SELECT
                        pp.product_id,
                        pp.price,
                        pp.valid_from,
                        ROW_NUMBER() OVER (
                            PARTITION BY pp.product_id
                            ORDER BY pp.valid_from DESC, pp.id DESC
                        ) AS rn
                    FROM product_price pp
                    WHERE pp.valid_from <= :untilValidFrom
                ) t
                WHERE t.rn = 1
            ) sub ON sub.product_id = p.id
            WHERE u.business_id = :userId
            """, nativeQuery = true)
    List<ProductInfo> findAllWithNewestPriceByUserBusinessId(UUID userId, LocalDate untilValidFrom);

    boolean existsByNameAndUserBusinessId(String name, BusinessId userId);

    boolean existsByBusinessIdAndUserBusinessId(BusinessId productId, BusinessId userId);

    void deleteByBusinessId(BusinessId productId);

}
