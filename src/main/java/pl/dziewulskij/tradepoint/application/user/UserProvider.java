package pl.dziewulskij.tradepoint.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.user.LoadUserPort;
import pl.dziewulskij.tradepoint.domain.exception.UserNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class UserProvider {

    private final LoadUserPort loadUserPort;

    public User byEmail(Email email) {
        return loadUserPort.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public User currentUser() {
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();
        return loadUserPort.findByBusinessId(currentUserId)
                .orElseThrow(UserNotFoundException::new);
    }

}
