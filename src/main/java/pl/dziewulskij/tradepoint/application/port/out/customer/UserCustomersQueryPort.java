package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

import java.util.List;
import java.util.Optional;

@OutputPort
public interface UserCustomersQueryPort {

    List<Customer> getAllByUserId(BusinessId userId);

    Optional<Customer> getByBusinessId(BusinessId customerId);

}
