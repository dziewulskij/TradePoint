package pl.dziewulskij.tradepoint.application.customer.service;

import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.mapper.DiscriminatedCustomerMapper;
import pl.dziewulskij.tradepoint.application.customer.provider.CustomerProvider;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Service
public class PersonCustomerCommandService extends CustomerCommandService<PersonCustomer> {

    public PersonCustomerCommandService(UserProvider userProvider,
                                        CustomerProvider<PersonCustomer> customerProvider,
                                        SaveCustomerPort<PersonCustomer> saveCustomerPort,
                                        DiscriminatedCustomerMapper<PersonCustomer> customerMapper) {
        super(userProvider, customerProvider, saveCustomerPort, customerMapper);
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.PERSON;
    }

    @Override
    public CommandCustomerResult update(BusinessId id, CustomerCommand command) {
        PersonCustomer customer = customerProvider.byBusinessId(id);
        customer.update(command);
        saveCustomerPort.save(customer);
        return customerMapper.toResult(customer);
    }
}
