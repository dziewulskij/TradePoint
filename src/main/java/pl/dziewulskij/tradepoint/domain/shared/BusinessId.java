package pl.dziewulskij.tradepoint.domain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@Accessors
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class BusinessId {

    @NonNull
    @Column(name = "business_id", length = 36, nullable = false, unique = true, updatable = false)
    UUID value;

    public BusinessId() {
        this.value = UUID.randomUUID();
    }

    public String stringValue() {
        return this.value.toString();
    }

    public static BusinessId fromString(@NonNull String value) {
        return BusinessId.of(UUID.fromString(value));
    }

}
