package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;

public interface SaveCustomerPort {

    void save(CompanyCustomer customer);

}
