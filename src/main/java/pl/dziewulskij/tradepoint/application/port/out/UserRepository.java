package pl.dziewulskij.tradepoint.application.port.out;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface UserRepository extends SaveUserPort, LoadUserPort {

    boolean existsByEmail(Email email);

}
