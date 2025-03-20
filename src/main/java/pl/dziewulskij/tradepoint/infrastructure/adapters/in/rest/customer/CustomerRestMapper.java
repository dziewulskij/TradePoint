package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer;

import org.mapstruct.Mapper;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.GetCustomerResponse;

import java.util.List;

@Mapper(imports = BusinessId.class)
public interface CustomerRestMapper {

    CustomerCommand toCommand(CustomerRequest request);

    CustomerResponse toResponse(CommandCustomerResult result);

    GetCustomerResponse toResponse(GetCustomerResult result);

    List<GetCustomerResponse> toResponseList(List<GetCustomerResult> results);

}
