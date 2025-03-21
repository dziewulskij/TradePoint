package pl.dziewulskij.tradepoint.application.customer.provider;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;

@Component
public class UnifiedCustomerProvider extends CustomerProvider<Customer> {

    public UnifiedCustomerProvider(LoadCustomerPort<Customer> loadCustomerPort) {
        super(loadCustomerPort);
    }
}
