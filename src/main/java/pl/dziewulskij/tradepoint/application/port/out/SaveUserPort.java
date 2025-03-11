package pl.dziewulskij.tradepoint.application.port.out;

import pl.dziewulskij.tradepoint.domain.user.User;

public interface SaveUserPort {

    void save(User user);

}
