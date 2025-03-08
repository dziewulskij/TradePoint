package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEqualValidator {

    public static void validate(RegisterUserRequest request) {
        var password = request.password();
        var confirmationPassword = request.confirmationPassword();

        if (!Objects.equals(password, confirmationPassword)) {
            throw new PasswordNotEqualException();
        }
    }

}
