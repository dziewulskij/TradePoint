package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.customer.CustomerExistencePort;
import pl.dziewulskij.tradepoint.application.port.out.customer.UserCustomersQueryPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UnifiedCustomerRepository implements UserCustomersQueryPort, CustomerExistencePort {

    private final CustomerJpaRepository<Customer> commonCustomerJpaRepository;

    @Override
    public List<Customer> getAllByUserId(BusinessId userId) {
        return commonCustomerJpaRepository.findByUserBusinessId(userId);
    }

    @Override
    public boolean existsByIdAndUserId(BusinessId customerId, BusinessId userId) {
        return commonCustomerJpaRepository.existsByBusinessIdAndUserBusinessId(customerId, userId);
    }
}
