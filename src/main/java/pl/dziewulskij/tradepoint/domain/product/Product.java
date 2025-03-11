package pl.dziewulskij.tradepoint.domain.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "PRODUCT",
        indexes = {
                @Index(name = "idx_product_business_id", columnList = "business_id", unique = true),
                @Index(name = "idx_product_name", columnList = "name")
        },
        uniqueConstraints = @UniqueConstraint(name = "uc_product__user_id__name__unit", columnNames = {"user_id", "name", "unit"})
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    @Builder.Default
    BusinessId businessId = new BusinessId();

    @Column(name = "name", length = 60, nullable = false)
    String name;

    @Column(name = "unit", length = 15)
    String unit;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}
