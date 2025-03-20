package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.customer.LoadCustomerPort;
import pl.dziewulskij.tradepoint.application.port.out.customer.SaveCustomerPort;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements SaveCustomerPort, LoadCustomerPort {

    private final CustomerJpaRepository customerJpaRepository;
    private final CompanyCustomerJpaRepository companyCustomerJpaRepository;
    private final PersonCustomerJpaRepository personCustomerJpaRepository;

    @Override
    public Optional<CompanyCustomer> getById(BusinessId customerId) {
        return companyCustomerJpaRepository.findByBusinessId(customerId);
    }

    @Override
    public List<CompanyCustomer> getAllByUserId(BusinessId userId) {
        return companyCustomerJpaRepository.findByUserBusinessId(userId);
    }

    @Override
    public void save(CompanyCustomer customer) {
        companyCustomerJpaRepository.save(customer);
    }
}
