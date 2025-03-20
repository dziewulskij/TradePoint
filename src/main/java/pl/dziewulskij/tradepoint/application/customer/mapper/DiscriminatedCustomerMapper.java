package pl.dziewulskij.tradepoint.application.customer.mapper;

import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.user.User;

public interface DiscriminatedCustomerMapper<T extends Customer> {

    T toCreate(CustomerCommand command, User user);

    @Mapping(source = "businessId.value", target = "id")
    @Mapping(source = "customerType", target = "type")
    CommandCustomerResult toResult(T customer);

    @Mapping(source = "businessId.value", target = "id")
    @Mapping(source = "customerType", target = "type")
    GetCustomerResult toResultGet(T customer);

}
