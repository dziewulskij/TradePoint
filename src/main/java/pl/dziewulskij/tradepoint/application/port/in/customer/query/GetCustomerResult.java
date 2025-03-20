package pl.dziewulskij.tradepoint.application.port.in.customer.query;

import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

import java.util.UUID;

public record GetCustomerResult(
        UUID id,
        String firstName,
        String lastName,
        String pesel,
        String email,
        String phone,
        String bankAccountNo,
        String companyName,
        String companyShortName,
        String taxId,
        String notes,
        CustomerType type
) {
}