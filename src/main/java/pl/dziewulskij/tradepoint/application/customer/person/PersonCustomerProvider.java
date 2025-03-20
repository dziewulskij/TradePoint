package pl.dziewulskij.tradepoint.application.customer.person;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.customer.CustomerProvider;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;

@Component
public class PersonCustomerProvider extends CustomerProvider<PersonCustomer> {

    public PersonCustomerProvider(LoadCustomerPort<PersonCustomer> loadCustomerPort) {
        super(loadCustomerPort);
    }
}
