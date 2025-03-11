package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterUserRestMapper {

    static RegisterUserCommand toCommand(RegisterUserRequest request) {
        return new RegisterUserCommand(
                request.email(),
                request.firstName(),
                request.lastName(),
                request.password()
        );
    }

    static RegisterUserResponse toResponse(RegisterUserResult userResult) {
        return new RegisterUserResponse(userResult.id(), userResult.email());
    }

}
