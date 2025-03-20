package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginCommand;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.TokenResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.UserLoginRequest;

@Mapper
public interface AuthApiMapper {

    UserLoginCommand toCommand(UserLoginRequest request);

    @Mapping(source = "token", target = "value")
    TokenResponse toResponse(UserLoginResult result);

}
