package pl.dziewulskij.tradepoint.application.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.customer.provider.CustomerCommandServiceProvider;
import pl.dziewulskij.tradepoint.application.customer.validator.CustomerBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommandUseCase;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class CustomerCommandServiceDelegate implements CustomerCommandUseCase {

    private final CustomerCommandServiceProvider customerCommandServiceProvider;
    private final CustomerBelongToUserValidator customerBelongToUserValidator;

    @Override
    public CommandCustomerResult create(CustomerCommand command) {
        return customerCommandServiceProvider.getService(command.type())
                .create(command);
    }

    @Override
    public CommandCustomerResult update(BusinessId customerId, CustomerCommand command) {
        customerBelongToUserValidator.validate(customerId);
        return customerCommandServiceProvider.getService(command.type())
                .update(customerId, command);
    }
}
