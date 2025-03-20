package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface SaveCustomerPort<T extends Customer> {

    void save(T customer);

}
