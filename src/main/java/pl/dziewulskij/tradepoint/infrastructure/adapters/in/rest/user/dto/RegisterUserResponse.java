package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto;

import java.util.UUID;

public record RegisterUserResponse(UUID id, String email) {
}
