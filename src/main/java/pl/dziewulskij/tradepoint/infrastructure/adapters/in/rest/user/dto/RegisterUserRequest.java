package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.share.validation.ValidPassword;

public record RegisterUserRequest(
        @Email
        @NotBlank
        @JsonProperty("email")
        String email,

        @NotBlank
        @Size(min = 1, max = 100)
        @JsonProperty("firstName")
        String firstName,

        @NotBlank
        @Size(min = 1, max = 100)
        @JsonProperty("lastName")
        String lastName,

        @ValidPassword
        @JsonProperty("password")
        String password,

        @JsonProperty("confirmationPassword")
        String confirmationPassword) {
}
