package pl.dziewulskij.tradepoint.application.port.in.user;

import java.util.UUID;

public record RegisterUserResult(UUID id, String email) {
}
