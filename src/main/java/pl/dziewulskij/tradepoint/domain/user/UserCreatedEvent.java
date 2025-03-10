package pl.dziewulskij.tradepoint.domain.user;

import pl.dziewulskij.tradepoint.domain.shared.Email;

public record UserCreatedEvent(Email email) {
}
