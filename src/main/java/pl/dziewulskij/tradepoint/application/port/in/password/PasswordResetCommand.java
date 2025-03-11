package pl.dziewulskij.tradepoint.application.port.in.password;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset.dto.ResetPasswordRequest;

import java.util.UUID;

public record PasswordResetCommand(
        @NonNull UUID token,
        @NonNull Email email,
        @NonNull String password
) {
    public static PasswordResetCommand from(ResetPasswordRequest request, UUID token) {
        return new PasswordResetCommand(token, new Email(request.email()), request.password());
    }
}
