package pl.dziewulskij.tradepoint.application.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.util.List;

@Mapper(imports = BusinessId.class)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastModifiedAt", ignore = true)
    @Mapping(target = "businessId", expression = "java(new BusinessId())")
    @Mapping(source = "command.email", target = "email")
    @Mapping(source = "command.phone", target = "phone")
    @Mapping(source = "user", target = "user")
    CompanyCustomer toCreate(CustomerCommand command, User user);

    @Mapping(source = "businessId.value", target = "id")
    CommandCustomerResult toResult(CompanyCustomer customer);

    @Mapping(source = "businessId.value", target = "id")
    GetCustomerResult toResultGet(CompanyCustomer customer);

    List<GetCustomerResult> toResultList(List<CompanyCustomer> customers);
}
