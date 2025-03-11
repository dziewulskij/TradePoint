package pl.dziewulskij.tradepoint.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.out.LoadUserPort;
import pl.dziewulskij.tradepoint.domain.exception.UserNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final LoadUserPort loadUserPort;

    public User findByEmailOrThrow(Email email) {
        return loadUserPort.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

}
