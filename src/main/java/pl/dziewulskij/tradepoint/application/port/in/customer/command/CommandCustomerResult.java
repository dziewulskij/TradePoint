package pl.dziewulskij.tradepoint.application.port.in.customer.command;

import java.util.UUID;

public record CommandCustomerResult(
        UUID id,
        String email,
        String phone,
        String bankAccountNo,
        String taxId,
        String notes,
        String companyName,
        String companyShortName
) {
}
