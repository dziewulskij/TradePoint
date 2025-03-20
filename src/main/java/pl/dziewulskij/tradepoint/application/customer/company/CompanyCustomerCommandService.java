package pl.dziewulskij.tradepoint.application.customer.company;

import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.CustomerCommandService;
import pl.dziewulskij.tradepoint.application.customer.CustomerProvider;
import pl.dziewulskij.tradepoint.application.customer.mapper.DiscriminatedCustomerMapper;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Service
public class CompanyCustomerCommandService extends CustomerCommandService<CompanyCustomer> {

    public CompanyCustomerCommandService(UserProvider userProvider,
                                         CustomerProvider<CompanyCustomer> customerProvider,
                                         SaveCustomerPort<CompanyCustomer> saveCustomerPort,
                                         DiscriminatedCustomerMapper<CompanyCustomer> customerMapper) {
        super(userProvider, customerProvider, saveCustomerPort, customerMapper);
    }

    @Override
    public CustomerType getCustomerType() {
        return CustomerType.COMPANY;
    }

    @Override
    public CommandCustomerResult update(BusinessId id, CustomerCommand command) {
        CompanyCustomer customer = customerProvider.byBusinessId(id);
        customer.update(command);
        saveCustomerPort.save(customer);
        return customerMapper.toResult(customer);
    }

}
