package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.passwordreset.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.ValidPassword;

public record ResetPasswordRequest(
        @Email
        @NotBlank
        @JsonProperty("email")
        String email,

        @ValidPassword
        @JsonProperty("password")
        String password,

        @JsonProperty("confirmationPassword")
        String confirmationPassword
) {
}
