package pl.dziewulskij.tradepoint.application.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.auth.port.in.UserLoginCommand;
import pl.dziewulskij.tradepoint.application.auth.port.in.UserLoginResult;
import pl.dziewulskij.tradepoint.application.auth.port.in.UserLoginUseCase;
import pl.dziewulskij.tradepoint.application.auth.port.out.AuthLoginRepository;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.security.model.JwtCreationDetails;
import pl.dziewulskij.tradepoint.infrastructure.security.provider.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService implements UserLoginUseCase {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthLoginRepository authLoginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserLoginResult login(UserLoginCommand command) {
        return authLoginRepository.findUserByEmail(new Email(command.email()))
                .filter(user -> passwordEncoder.matches(command.password(), user.getPassword()))
                .map(JwtCreationDetails::new)
                .map(jwtTokenProvider::generateToken)
                .map(UserLoginResult::new)
                .orElseThrow(AuthenticationException::new);
    }

}
