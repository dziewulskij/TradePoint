package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommandUseCase;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class CustomerCommandServiceDelegate implements CustomerCommandUseCase {

    private final CustomerCommandServiceProvider customerCommandServiceProvider;

    @Override
    public CommandCustomerResult create(CustomerCommand command) {
        return customerCommandServiceProvider.getService(command.type())
                .create(command);
    }

    @Override
    public CommandCustomerResult update(BusinessId id, CustomerCommand command) {
        return customerCommandServiceProvider.getService(command.type())
                .update(id, command);
    }
}
