package pl.dziewulskij.tradepoint.domain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Setter
@Getter
@Accessors
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quantity {

    @Column(name = "qty", precision = 19, scale = 2)
    BigDecimal value;

}
