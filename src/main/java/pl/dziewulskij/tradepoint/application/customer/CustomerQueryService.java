package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.mapper.UnifiedCustomerMapper;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.CustomerQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.application.port.out.customer.UserCustomersQueryPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQueryService implements CustomerQueryUseCase {

    private final UnifiedCustomerMapper customerMapper;
    private final UserCustomersQueryPort userCustomersQueryPort;

    @Override
    public List<GetCustomerResult> getAll() {
        List<Customer> customers = userCustomersQueryPort.getAllByUserId(AuthenticationUtils.getCurrentUserId());
        return customerMapper.mapList(customers);
    }

}
