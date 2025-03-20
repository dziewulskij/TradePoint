package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.exception.CustomerNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class CustomerProvider {

    private final LoadCustomerPort loadCustomerPort;

    public CompanyCustomer byBusinessId(BusinessId customerId) {
        return loadCustomerPort.getById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
    }

}
