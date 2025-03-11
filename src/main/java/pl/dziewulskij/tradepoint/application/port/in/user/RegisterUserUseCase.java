package pl.dziewulskij.tradepoint.application.port.in.user;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface RegisterUserUseCase {

    RegisterUserResult register(RegisterUserCommand command);

}
