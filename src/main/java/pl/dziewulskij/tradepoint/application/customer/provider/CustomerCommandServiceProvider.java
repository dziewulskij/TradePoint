package pl.dziewulskij.tradepoint.application.customer.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.service.CustomerCommandService;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceProvider {

    private final List<CustomerCommandService<?>> customerCommandServices;

    public CustomerCommandService<?> getService(CustomerType customerType) {
        return customerCommandServices.stream()
                .filter(service -> service.getCustomerType() == customerType)
                .findFirst()
                .orElseThrow();
    }

}
