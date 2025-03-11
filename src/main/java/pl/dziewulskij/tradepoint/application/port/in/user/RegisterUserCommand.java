package pl.dziewulskij.tradepoint.application.port.in.user;

public record RegisterUserCommand(String email,
                                  String firstName,
                                  String lastName,
                                  String password) {

}
