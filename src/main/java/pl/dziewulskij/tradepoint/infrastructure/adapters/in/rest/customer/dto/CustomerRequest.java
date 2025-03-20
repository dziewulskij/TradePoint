package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.pl.NIP;

public record CustomerRequest(
        @Email
        @Size(max = 100)
        String email,

        @Size(max = 15)
        String phone,

        @Size(max = 26)
        String bankAccountNo,

        @NIP
        String taxId,

        @Size(max = 255)
        String notes,

        @NotBlank
        String companyName,

        String companyShortName
) {
}
