package pl.dziewulskij.tradepoint.application.port.in.password;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.domain.shared.Email;

public record PasswordResetRequestCommand(@NonNull Email email) {

    public static PasswordResetRequestCommand of(@NonNull String email) {
        return new PasswordResetRequestCommand(Email.of(email));
    }
}
