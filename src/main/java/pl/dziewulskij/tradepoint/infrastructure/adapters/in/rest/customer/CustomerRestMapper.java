package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer;

import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.GetCustomerResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerRestMapper {

    static CustomerCommand toCommand(CustomerRequest request) {
        return new CustomerCommand(
                request.email(),
                request.phone(),
                request.bankAccountNo(),
                request.taxId(),
                request.notes(),
                request.companyName(),
                request.companyShortName()
        );
    }

    static CustomerResponse toResponse(CommandCustomerResult result) {
        return new CustomerResponse(
                result.id(),
                result.email(),
                result.phone(),
                result.bankAccountNo(),
                result.taxId(),
                result.notes(),
                result.companyName(),
                result.companyShortName()
        );
    }

    static GetCustomerResponse toResponse(GetCustomerResult result) {
        return new GetCustomerResponse(
                result.id(),
                result.email(),
                result.phone(),
                result.bankAccountNo(),
                result.taxId(),
                result.notes(),
                result.companyName(),
                result.companyShortName()
        );
    }

    static List<GetCustomerResponse> toResponseList(List<GetCustomerResult> results) {
        return Stream.ofNullable(results)
                .flatMap(Collection::stream)
                .map(CustomerRestMapper::toResponse)
                .collect(Collectors.toList());
    }
}
