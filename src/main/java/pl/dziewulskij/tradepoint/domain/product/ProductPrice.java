package pl.dziewulskij.tradepoint.domain.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.CreateProductPriceCommand;
import pl.dziewulskij.tradepoint.domain.audit.TimeAuditable;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Price;

import java.time.LocalDate;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "PRODUCT_PRICE",
        indexes = {
                @Index(name = "idx_product_price_business_id", columnList = "business_id", unique = true)
        }
)
public class ProductPrice extends TimeAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    @Builder.Default
    BusinessId businessId = new BusinessId();

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price", nullable = false, precision = 19, scale = 2))
    Price price;

    @Column(name = "valid_from", nullable = false)
    LocalDate validFrom;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    public static ProductPrice create(CreateProductPriceCommand command, Product product) {
        return ProductPrice.builder()
                .validFrom(command.validFrom())
                .price(command.price())
                .product(product)
                .build();
    }

}
