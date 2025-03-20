package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class CustomerCommandService implements CustomerCommandUseCase {

    private final SaveCustomerPort saveCustomerPort;
    private final CustomerProvider customerProvider;
    private final UserProvider userProvider;

    @Override
    public CommandCustomerResult create(CustomerCommand command) {
        User user = userProvider.currentUser();
        CompanyCustomer customer = CustomerMapper.toCreate(command, user);
        saveCustomerPort.save(customer);
        return CustomerMapper.toResult(customer);
    }

    @Override
    public CommandCustomerResult update(BusinessId id, CustomerCommand command) {
        CompanyCustomer customer = customerProvider.byBusinessId(id);
        customer.update(command);
        saveCustomerPort.save(customer);
        return CustomerMapper.toResult(customer);
    }

}
