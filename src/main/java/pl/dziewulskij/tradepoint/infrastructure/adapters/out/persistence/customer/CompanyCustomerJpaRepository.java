package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

public interface CompanyCustomerJpaRepository extends JpaRepository<CompanyCustomer, Long> {
    Optional<CompanyCustomer> findByBusinessId(BusinessId businessId);

    List<CompanyCustomer> findByUserBusinessId(BusinessId businessId);
}
