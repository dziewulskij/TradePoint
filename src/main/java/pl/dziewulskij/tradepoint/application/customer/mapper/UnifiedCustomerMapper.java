package pl.dziewulskij.tradepoint.application.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;

import java.util.List;
import java.util.Objects;

@Mapper
public interface UnifiedCustomerMapper {

    CompanyCustomerMapper COMPANY_MAPPER = Mappers.getMapper(CompanyCustomerMapper.class);
    PersonCustomerMapper PERSON_MAPPER = Mappers.getMapper(PersonCustomerMapper.class);

    default List<GetCustomerResult> mapList(List<Customer> customers) {
        return customers.stream()
                .filter(Objects::nonNull)
                .map(this::mapCustomer)
                .filter(Objects::nonNull)
                .toList();
    }

    private GetCustomerResult mapCustomer(Customer customer) {
        if (customer instanceof CompanyCustomer companyCustomer) {
            return COMPANY_MAPPER.toResultGet(companyCustomer);
        } else if (customer instanceof PersonCustomer personCustomer) {
            return PERSON_MAPPER.toResultGet(personCustomer);
        }
        return null;
    }

}
