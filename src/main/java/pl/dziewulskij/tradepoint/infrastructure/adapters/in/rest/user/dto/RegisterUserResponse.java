package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RegisterUserResponse(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("email")
        String email
) {
}
