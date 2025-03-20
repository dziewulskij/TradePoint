package pl.dziewulskij.tradepoint.application.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Mapper(imports = BusinessId.class)
public interface PersonCustomerMapper extends DiscriminatedCustomerMapper<PersonCustomer> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastModifiedAt", ignore = true)
    @Mapping(target = "businessId", expression = "java(new BusinessId())")
    @Mapping(source = "command.email", target = "email")
    @Mapping(source = "command.phone", target = "phone")
    @Mapping(source = "command.firstName", target = "firstName")
    @Mapping(source = "command.lastName", target = "lastName")
    @Mapping(source = "user", target = "user")
    PersonCustomer toCreate(CustomerCommand command, User user);

}
