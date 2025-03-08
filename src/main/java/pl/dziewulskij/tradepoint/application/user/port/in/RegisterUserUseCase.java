package pl.dziewulskij.tradepoint.application.user.port.in;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface RegisterUserUseCase {

    RegisterUserResult register(RegisterUserCommand command);

}
