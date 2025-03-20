package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import pl.dziewulskij.tradepoint.application.customer.mapper.DiscriminatedCustomerMapper;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@RequiredArgsConstructor
public abstract class CustomerCommandService<T extends Customer> {

    protected final UserProvider userProvider;
    protected final CustomerProvider<T> customerProvider;
    protected final SaveCustomerPort<T> saveCustomerPort;
    protected final DiscriminatedCustomerMapper<T> customerMapper;

    public abstract CustomerType getCustomerType();

    public abstract CommandCustomerResult update(BusinessId id, CustomerCommand command);

    public CommandCustomerResult create(CustomerCommand command) {
        User user = userProvider.currentUser();
        T customer = customerMapper.toCreate(command, user);
        saveCustomerPort.save(customer);
        return customerMapper.toResult(customer);
    }

}
