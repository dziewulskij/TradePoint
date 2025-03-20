package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;

public interface PersonCustomerJpaRepository extends JpaRepository<PersonCustomer, Long> {

}
