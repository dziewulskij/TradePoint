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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@OutputAdapter
@Repository("userInMemoryRepositoryAdapter")
@RequiredArgsConstructor
public class UserInMemoryRepositoryAdapter implements LoadUserPort, SaveUserPort, ExistsUserPort {

    private final Map<BusinessId, User> users = new HashMap<>();

    @Override
    public boolean existsByEmail(Email email) {
        return users.values().stream()
                .anyMatch(user -> user.getEmail().equals(email.value()));
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email.value()))
                .findFirst();
    }

    @Override
    public Optional<User> findByBusinessId(BusinessId id) {
        return users.containsKey(id) ? Optional.of(users.get(id)) : Optional.empty();
    }

    @Override
    public void save(User user) {
        users.put(user.getBusinessId(), user);
    }
}
