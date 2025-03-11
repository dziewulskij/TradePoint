package pl.dziewulskij.tradepoint.application.user;

import lombok.NonNull;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserResult;
import pl.dziewulskij.tradepoint.domain.shared.Password;
import pl.dziewulskij.tradepoint.domain.user.User;

public class RegisterUserMapper {

    static User toEntity(@NonNull RegisterUserCommand command, @NonNull Password encodedPassword) {
        return User.builder()
                .email(command.email())
                .firstName(command.firstName())
                .lastName(command.lastName())
                .password(encodedPassword.hashedValue())
                .build();
    }

    static RegisterUserResult toResponse(@NonNull User user) {
        return new RegisterUserResult(
                user.getBusinessId().value(),
                user.getEmail()
        );
    }

}
