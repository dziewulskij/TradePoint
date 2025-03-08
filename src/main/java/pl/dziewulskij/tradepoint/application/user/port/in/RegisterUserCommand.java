package pl.dziewulskij.tradepoint.application.user.port.in;

public record RegisterUserCommand(String email,
                                  String firstName,
                                  String lastName,
                                  String password) {

}
