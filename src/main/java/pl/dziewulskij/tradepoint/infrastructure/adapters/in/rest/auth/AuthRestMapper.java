package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dziewulskij.tradepoint.application.auth.port.in.UserLoginCommand;
import pl.dziewulskij.tradepoint.application.auth.port.in.UserLoginResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.TokenResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.UserLoginRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthRestMapper {

    static UserLoginCommand toCommand(UserLoginRequest request) {
        return new UserLoginCommand(request.email(), request.password());
    }

    static TokenResponse toResponse(UserLoginResult result) {
        return new TokenResponse(result.token());
    }

}
