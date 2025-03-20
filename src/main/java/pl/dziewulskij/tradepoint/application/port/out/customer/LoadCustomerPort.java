package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.Optional;

@OutputPort
public interface LoadCustomerPort<T extends Customer> {

    Optional<T> getById(BusinessId customerId);

}
