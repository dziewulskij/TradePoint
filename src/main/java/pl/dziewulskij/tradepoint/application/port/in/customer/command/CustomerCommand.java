package pl.dziewulskij.tradepoint.application.port.in.customer.command;

import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

public record CustomerCommand(
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
