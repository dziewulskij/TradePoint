package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.passwordreset;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.password.PasswordReset;

import java.util.Optional;
import java.util.UUID;

public interface JpaPasswordResetRepository extends JpaRepository<PasswordReset, Long> {

    Optional<PasswordReset> findByTokenAndUserEmail(UUID token, String email);

    void deleteByToken(UUID token);
}
