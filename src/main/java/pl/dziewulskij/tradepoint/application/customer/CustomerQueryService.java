package pl.dziewulskij.tradepoint.application.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.CustomerQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQueryService implements CustomerQueryUseCase {

    private final LoadCustomerPort loadCustomerPort;
    private final CustomerMapper customerMapper;

    @Override
    public List<GetCustomerResult> getAll() {
        List<CompanyCustomer> customers = loadCustomerPort.getAllByUserId(AuthenticationUtils.getCurrentUserId());
        return customerMapper.toResultList(customers);
    }
}
