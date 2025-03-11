package pl.dziewulskij.tradepoint.application.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginCommand;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginResult;
import pl.dziewulskij.tradepoint.application.port.in.auth.UserLoginUseCase;
import pl.dziewulskij.tradepoint.application.port.out.LoadUserPort;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.security.model.JwtCreationDetails;
import pl.dziewulskij.tradepoint.infrastructure.security.provider.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService implements UserLoginUseCase {

    private final LoadUserPort loadUserPort;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserLoginResult login(UserLoginCommand command) {
        return loadUserPort.findByEmail(new Email(command.email()))
                .filter(user -> passwordEncoder.matches(command.password(), user.getPassword()))
                .map(JwtCreationDetails::new)
                .map(jwtTokenProvider::generateToken)
                .map(UserLoginResult::new)
                .orElseThrow(AuthenticationException::new);
    }

}
