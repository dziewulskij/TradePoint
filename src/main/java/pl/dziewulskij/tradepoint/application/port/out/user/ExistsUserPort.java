package pl.dziewulskij.tradepoint.application.port.out.user;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface ExistsUserPort {

    boolean existsByEmail(Email email);

}
