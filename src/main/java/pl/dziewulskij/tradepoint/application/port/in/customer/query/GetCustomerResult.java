package pl.dziewulskij.tradepoint.application.port.in.customer.query;

import java.util.UUID;

public record GetCustomerResult(
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