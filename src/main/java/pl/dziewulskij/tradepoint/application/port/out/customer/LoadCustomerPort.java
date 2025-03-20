package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

public interface LoadCustomerPort {

    Optional<CompanyCustomer> getById(BusinessId productId);

    List<CompanyCustomer> getAllByUserId(BusinessId userId);

}
