package pl.dziewulskij.tradepoint.application.auth.port.in;

public record UserLoginCommand(String email, String password) {
}
