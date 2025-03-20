package pl.dziewulskij.tradepoint.application.port.in.customer.command;

import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

import java.util.UUID;

public record CommandCustomerResult(
        UUID id,
        String firstName,
        String lastName,
        String pesel,
        String email,
        String phone,
        String bankAccountNo,
        String taxId,
        String notes,
        String companyName,
        String companyShortName,
        CustomerType type
) {
}
