package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.passwordreset;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.password.PasswordResetPort;
import pl.dziewulskij.tradepoint.domain.password.PasswordReset;
import pl.dziewulskij.tradepoint.domain.shared.Email;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PasswordResetRepositoryAdapter implements PasswordResetPort {

    private final PasswordResetJpaRepository passwordResetJpaRepository;

    @Override
    public Optional<PasswordReset> findByTokenAndUserEmail(UUID token, Email email) {
        return passwordResetJpaRepository.findByTokenAndUserEmail(token, email.value());
    }

    @Override
    public PasswordReset save(PasswordReset passwordReset) {
        return passwordResetJpaRepository.save(passwordReset);
    }

    @Override
    public void deleteByToken(UUID token) {
        passwordResetJpaRepository.deleteByToken(token);
    }

}
