package pl.dziewulskij.tradepoint.application.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionCustomerResult;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;

@Mapper
public interface TransactionCustomerMapper {

    @Mapping(source = "businessId", target = "id")
    GetTransactionCustomerResult map(CompanyCustomer companyCustomer);

    @Mapping(source = "businessId", target = "id")
    GetTransactionCustomerResult map(PersonCustomer personCustomer);

    default GetTransactionCustomerResult map(Customer customer) {
        if (customer instanceof CompanyCustomer) {
            return map((CompanyCustomer) customer);
        } else if (customer instanceof PersonCustomer) {
            return map((PersonCustomer) customer);
        } else {
            return null;
        }
    }
}
