package pl.dziewulskij.tradepoint.application.user.port.out;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface UserRepository {

    boolean existsByEmail(Email email);

    User save(User user);

}
