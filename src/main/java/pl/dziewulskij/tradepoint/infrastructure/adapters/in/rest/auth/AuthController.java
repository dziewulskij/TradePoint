package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginCommand;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginResult;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginUseCase;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.TokenResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto.UserLoginRequest;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

@InputAdapter
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginUseCase userLoginUseCase;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        UserLoginCommand command = AuthRestMapper.toCommand(request);
        UserLoginResult userLoginResult = userLoginUseCase.login(command);
        return AuthRestMapper.toResponse(userLoginResult);
    }

}
