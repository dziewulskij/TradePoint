package pl.dziewulskij.tradepoint.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserCommand;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserResult;
import pl.dziewulskij.tradepoint.application.user.port.in.RegisterUserUseCase;
import pl.dziewulskij.tradepoint.application.user.port.out.UserRepository;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.domain.shared.Password;
import pl.dziewulskij.tradepoint.domain.user.User;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPortImpl;

@InputPortImpl
@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserValidator validator;

    @Override
    @Transactional
    public RegisterUserResult register(RegisterUserCommand command) {
        validator.validateUserUniqueness(new Email(command.email()));
        Password encodedPassword = encodePassword(command.password());
        User user = RegisterUserMapper.toEntity(command, encodedPassword);
        userRepository.save(user);
        return RegisterUserMapper.toResponse(user);
    }

    private Password encodePassword(String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return new Password(encodedPassword);
    }

}
