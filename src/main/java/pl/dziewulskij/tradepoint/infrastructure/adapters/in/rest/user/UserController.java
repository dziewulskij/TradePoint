package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserResult;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserUseCase;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto.RegisterUserResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.validation.PasswordEqualValidator;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

@InputAdapter
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponse register(@RequestBody @Valid RegisterUserRequest request) {
        PasswordEqualValidator.validate(request);
        RegisterUserCommand command = RegisterUserRestMapper.toCommand(request);
        RegisterUserResult registerUserResult = registerUserUseCase.register(command);
        return RegisterUserRestMapper.toResponse(registerUserResult);
    }

}
