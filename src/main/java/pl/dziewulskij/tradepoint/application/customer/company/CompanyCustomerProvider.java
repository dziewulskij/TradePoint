package pl.dziewulskij.tradepoint.application.customer.company;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.customer.CustomerProvider;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;

@Component
public class CompanyCustomerProvider extends CustomerProvider<CompanyCustomer> {

    public CompanyCustomerProvider(LoadCustomerPort<CompanyCustomer> loadCustomerPort) {
        super(loadCustomerPort);
    }

}
