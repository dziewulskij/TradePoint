package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;
import java.util.Optional;

public interface CustomerJpaRepository<T extends Customer> extends JpaRepository<T, Long> {

    Optional<T> findByBusinessId(BusinessId customerId);

    List<T> findByUserBusinessId(BusinessId customerId);

    boolean existsByBusinessIdAndUserBusinessId(BusinessId customerId, BusinessId userId);

}
