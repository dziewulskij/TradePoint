package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordEqualValidator {

    public static void validate(PasswordMatchData passwordMatchData) {
        var password = passwordMatchData.password();
        var confirmationPassword = passwordMatchData.confirmPassword();

        if (!Objects.equals(password, confirmationPassword)) {
            throw new PasswordNotEqualException();
        }
    }

}
