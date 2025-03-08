package pl.dziewulskij.tradepoint.infrastructure.security.model;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

public record JwtCreationDetails(@NonNull BusinessId id,
                                 @NonNull String email,
                                 @NonNull String firstName,
                                 @NonNull String lastName) {

    public JwtCreationDetails(User user) {
        this(user.getBusinessId(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

}
