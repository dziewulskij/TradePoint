package pl.dziewulskij.tradepoint.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.user.LoadUserPort;
import pl.dziewulskij.tradepoint.domain.exception.UserNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;

@Component
@RequiredArgsConstructor
public class UserProvider {

    private final LoadUserPort loadUserPort;

    public User byEmail(Email email) {
        return loadUserPort.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public User byBusinessId(BusinessId id) {
        return loadUserPort.findByBusinessId(id)
                .orElseThrow(UserNotFoundException::new);
    }

}
