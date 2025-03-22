package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerRequest;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerApiValidator {

    public static void validate(CustomerRequest request) {
        if (request.type() == CustomerType.PERSON) {
            Objects.requireNonNull(request.firstName());
            Objects.requireNonNull(request.lastName());
        }
        if (request.type() == CustomerType.COMPANY) {
            Objects.requireNonNull(request.companyName());
        }
    }

}
