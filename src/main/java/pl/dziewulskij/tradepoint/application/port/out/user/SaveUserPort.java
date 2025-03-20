package pl.dziewulskij.tradepoint.application.port.out.user;

import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface SaveUserPort {

    void save(User user);

}
