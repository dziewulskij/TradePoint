package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetCommand;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetRequestCommand;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetUseCase;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset.dto.ResetPasswordRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.PasswordEqualValidator;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.PasswordMatchData;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.UUID;

@InputAdapter
@RestController
@RequestMapping("/api/reset-passwords")
@RequiredArgsConstructor
public class PasswordResetController {

    private final PasswordResetUseCase passwordResetUseCase;

    @PostMapping("/requests")
    @ResponseStatus(HttpStatus.OK)
    public void request(@RequestParam("email") String email) {
        passwordResetUseCase.request(PasswordResetRequestCommand.of(email));
    }

    @PostMapping("/resets")
    @ResponseStatus(HttpStatus.OK)
    public void reset(@RequestBody @Valid ResetPasswordRequest request,
                      @RequestHeader("X-PASSWORD-RESET-TOKEN") UUID token) {
        PasswordEqualValidator.validate(PasswordMatchData.from(request));
        passwordResetUseCase.reset(PasswordResetCommand.from(request, token));
    }

}
