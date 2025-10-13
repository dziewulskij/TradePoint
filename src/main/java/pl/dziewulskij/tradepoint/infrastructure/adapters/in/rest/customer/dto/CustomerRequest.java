package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.pl.NIP;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

public record CustomerRequest(
        @JsonProperty("firstName")
        @Size(max = 100)
        String firstName,

        @JsonProperty("lastName")
        @Size(max = 100)
        String lastName,

        @JsonProperty("pesel")
        @Size(max = 11)
        String pesel,

        @JsonProperty("email")
        @Email
        @Size(max = 100)
        String email,

        @JsonProperty("phone")
        @Size(max = 15)
        String phone,

        @JsonProperty("bankAccountNo")
        @Size(max = 26)
        String bankAccountNo,

        @JsonProperty("taxId")
        @NIP
        String taxId,

        @JsonProperty("notes")
        @Size(max = 255)
        String notes,

        @JsonProperty("companyName")
        String companyName,

        @JsonProperty("companyShortName")
        String companyShortName,

        @JsonProperty("type")
        @NotNull
        CustomerType type
) {
}
