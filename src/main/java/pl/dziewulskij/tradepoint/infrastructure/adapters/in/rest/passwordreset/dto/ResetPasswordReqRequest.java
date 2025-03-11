package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ResetPasswordReqRequest(
        @Email
        @NotBlank
        @JsonProperty("email")
        String email
) {
}
