package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String email,
        String phone,
        String bankAccountNo,
        String companyName,
        String companyShortName,
        String taxId,
        String notes
) {
}
