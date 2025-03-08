package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.auth.port.out.AuthLoginRepository;
import pl.dziewulskij.tradepoint.application.user.port.out.UserRepository;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

import java.util.Optional;

@OutputAdapter
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository, AuthLoginRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return jpaUserRepository.existsByEmail(email.value());
    }

    @Override
    public Optional<User> findUserByEmail(Email email) {
        return jpaUserRepository.findByEmail(email.value());
    }
}
