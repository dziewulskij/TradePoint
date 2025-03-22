package pl.dziewulskij.tradepoint.application.port.in.transaction.query;

import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

public record GetTransactionCustomerResult(
        BusinessId id,
        String firstName,
        String lastName,
        String companyName,
        String taxId,
        String phone,
        CustomerType customerType
) {
}
