package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset.dto.ResetPasswordRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;

public record PasswordMatchData(@NonNull String password, @NonNull String confirmPassword) {

    public static PasswordMatchData from(ResetPasswordRequest request) {
        return new PasswordMatchData(request.password(), request.confirmationPassword());
    }

    public static PasswordMatchData from(RegisterUserRequest request) {
        return new PasswordMatchData(request.password(), request.confirmationPassword());
    }

}
