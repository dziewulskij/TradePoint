package pl.dziewulskij.tradepoint.application.password;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetCommand;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetRequestCommand;
import pl.dziewulskij.tradepoint.application.port.in.password.PasswordResetUseCase;
import pl.dziewulskij.tradepoint.application.port.out.PasswordResetPort;
import pl.dziewulskij.tradepoint.application.user.UserQueryService;
import pl.dziewulskij.tradepoint.domain.exception.PasswordResetNotFoundException;
import pl.dziewulskij.tradepoint.domain.password.PasswordReset;
import pl.dziewulskij.tradepoint.domain.password.PasswordResetRequestEvent;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class PasswordResetService implements PasswordResetUseCase {

    private final PasswordEncoder passwordEncoder;
    private final PasswordResetPort passwordResetPort;
    private final ApplicationEventPublisher eventPublisher;
    private final UserQueryService userQueryService;

    @Override
    public void request(PasswordResetRequestCommand command) {
        User user = userQueryService.findByEmailOrThrow(command.email());
        PasswordReset passwordReset = passwordResetPort.save(PasswordReset.of(user));
        eventPublisher.publishEvent(new PasswordResetRequestEvent(command.email(), passwordReset.getToken()));
    }

    @Override
    @Transactional
    public void reset(PasswordResetCommand command) {
        passwordResetPort.findByTokenAndUserEmail(command.token(), command.email())
                .filter(Predicate.not(PasswordReset::isExpired))
                .orElseThrow(PasswordResetNotFoundException::new);

        User user = userQueryService.findByEmailOrThrow(command.email());
        user.setPassword(passwordEncoder.encode(command.password()));
        passwordResetPort.deleteByToken(command.token());
    }

}
