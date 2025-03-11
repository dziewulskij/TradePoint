package pl.dziewulskij.tradepoint.application.port.in.auth;

public record UserLoginCommand(String email, String password) {
}
