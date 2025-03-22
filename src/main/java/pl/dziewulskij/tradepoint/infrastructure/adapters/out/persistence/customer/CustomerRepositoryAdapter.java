package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

import java.util.Optional;

@OutputAdapter
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter<T extends Customer> implements SaveCustomerPort<T>, LoadCustomerPort<T> {

    private final CustomerJpaRepository<T> customerJpaRepository;

    @Override
    public Optional<T> getById(BusinessId customerId) {
        return customerJpaRepository.findByBusinessId(customerId);
    }

    @Override
    public void save(T customer) {
        customerJpaRepository.save(customer);
    }

}
