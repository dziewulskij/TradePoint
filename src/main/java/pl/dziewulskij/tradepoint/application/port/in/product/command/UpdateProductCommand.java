package pl.dziewulskij.tradepoint.application.port.in.product.command;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.UUID;

public record UpdateProductCommand(@NonNull UUID id, @NonNull String name, String unit) {

    public BusinessId businessId() {
        return BusinessId.of(this.id);
    }

}
