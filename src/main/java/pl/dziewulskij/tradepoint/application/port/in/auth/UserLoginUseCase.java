package pl.dziewulskij.tradepoint.application.port.in.auth;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface UserLoginUseCase {

    UserLoginResult login(UserLoginCommand command);

}
