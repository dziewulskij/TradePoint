package pl.dziewulskij.tradepoint.domain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Accessors(fluent = true)
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

}
