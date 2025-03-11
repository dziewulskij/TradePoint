package pl.dziewulskij.tradepoint.domain.password;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.Email;

import java.util.UUID;

public record PasswordResetRequestEvent(@NonNull Email email, @NonNull UUID token) {
}
