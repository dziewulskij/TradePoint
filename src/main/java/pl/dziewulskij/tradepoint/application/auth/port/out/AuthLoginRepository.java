package pl.dziewulskij.tradepoint.application.auth.port.out;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.Optional;

@OutputPort
public interface AuthLoginRepository {

    Optional<User> findUserByEmail(Email email);

}
