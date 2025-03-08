package pl.dziewulskij.tradepoint.infrastructure.security.model;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

public record JwtCreationDetails(@NonNull BusinessId id,
                                 @NonNull String email,
                                 @NonNull String firstName,
                                 @NonNull String lastName) {

}
