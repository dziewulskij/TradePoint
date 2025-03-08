package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UserLoginRequest(
        @NotBlank
        @JsonProperty("email")
        String email,

        @NotBlank
        @JsonProperty("password")
        String password
) {
}
