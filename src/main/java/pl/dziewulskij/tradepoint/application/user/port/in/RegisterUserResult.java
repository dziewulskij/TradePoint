package pl.dziewulskij.tradepoint.application.user.port.in;

import java.util.UUID;

public record RegisterUserResult(UUID id, String email) {
}
