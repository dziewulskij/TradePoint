package pl.dziewulskij.tradepoint.application.auth.port.in;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface UserLoginUseCase {

    UserLoginResult login(UserLoginCommand command);

}
