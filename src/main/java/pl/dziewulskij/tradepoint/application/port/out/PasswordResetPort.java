package pl.dziewulskij.tradepoint.application.port.out;

import pl.dziewulskij.tradepoint.domain.password.PasswordReset;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.Optional;
import java.util.UUID;

@OutputPort
public interface PasswordResetPort {

    Optional<PasswordReset> findByTokenAndUserEmail(UUID token, Email email);

    PasswordReset save(PasswordReset passwordReset);

    void deleteByToken(UUID token);

}
