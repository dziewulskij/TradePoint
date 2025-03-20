package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user;

import org.mapstruct.Mapper;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserResponse;

@Mapper
public interface RegisterIUserApiMapper {

    RegisterUserCommand toCommand(RegisterUserRequest request);

    RegisterUserResponse toResponse(RegisterUserResult result);

}
