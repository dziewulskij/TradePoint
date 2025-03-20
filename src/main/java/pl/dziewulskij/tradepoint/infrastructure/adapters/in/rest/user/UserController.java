package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserResult;
import pl.dziewulskij.tradepoint.application.port.in.user.RegisterUserUseCase;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.PasswordEqualValidator;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.PasswordMatchData;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

@InputAdapter
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final RegisterIUserApiMapper registerIUserApiMapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponse register(@RequestBody @Valid RegisterUserRequest request) {
        PasswordEqualValidator.validate(PasswordMatchData.from(request));
        RegisterUserCommand command = registerIUserApiMapper.toCommand(request);
        RegisterUserResult registerUserResult = registerUserUseCase.register(command);
        return registerIUserApiMapper.toResponse(registerUserResult);
    }

}
