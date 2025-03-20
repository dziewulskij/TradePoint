package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.customer.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {


}
