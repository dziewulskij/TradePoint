package pl.dziewulskij.tradepoint.application.port.in.password;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface PasswordResetUseCase {

    void request(PasswordResetRequestCommand command);

    void reset(PasswordResetCommand command);

}
