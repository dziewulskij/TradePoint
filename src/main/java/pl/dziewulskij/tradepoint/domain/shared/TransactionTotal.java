package pl.dziewulskij.tradepoint.domain.shared;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

@Setter
@Getter
@Accessors
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTotal {

    @Embedded
    Price price;

    @Embedded
    Quantity quantity;

    public BigDecimal total() {
        if (!(priceNotNull() && qtyNotNull())) return BigDecimal.ZERO;
        return quantity.getValue().multiply(price.getValue());
    }

    private boolean priceNotNull() {
        return ObjectUtils.allNotNull(price, price.getValue());
    }

    private boolean qtyNotNull() {
        return ObjectUtils.allNotNull(quantity, quantity.getValue());
    }

}
