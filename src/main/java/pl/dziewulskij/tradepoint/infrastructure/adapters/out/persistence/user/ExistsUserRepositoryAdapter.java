package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.user.ExistsUserPort;
import pl.dziewulskij.tradepoint.application.port.out.user.LoadUserPort;
import pl.dziewulskij.tradepoint.application.port.out.user.SaveUserPort;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

import java.util.Optional;

@OutputAdapter
@Repository
@RequiredArgsConstructor
public class ExistsUserRepositoryAdapter implements LoadUserPort, SaveUserPort, ExistsUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userJpaRepository.existsByEmail(email.value());
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userJpaRepository.findByEmail(email.value());
    }

    @Override
    public Optional<User> findByBusinessId(BusinessId id) {
        return userJpaRepository.findByBusinessId(id);
    }
}
