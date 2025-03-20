package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.exception.CustomerNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@RequiredArgsConstructor
public abstract class CustomerProvider<T extends Customer> {

    private final LoadCustomerPort<T> loadCustomerPort;

    public T byBusinessId(BusinessId customerId) {
        return loadCustomerPort.getById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
    }

}
