package pl.dziewulskij.tradepoint.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.UserRepository;
import pl.dziewulskij.tradepoint.domain.exception.UserAlreadyExistsException;
import pl.dziewulskij.tradepoint.domain.shared.Email;

@Component
@RequiredArgsConstructor
class RegisterUserValidator {

    private final UserRepository userRepository;

    void validateUserUniqueness(Email email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException();
        }
    }

}
