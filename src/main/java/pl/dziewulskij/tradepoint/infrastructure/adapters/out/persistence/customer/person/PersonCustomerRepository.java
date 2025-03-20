package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.person;

import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.CustomerRepository;

@Repository
public class PersonCustomerRepository extends CustomerRepository<PersonCustomer> {

    public PersonCustomerRepository(PersonCustomerJpaRepository personCustomerJpaRepository) {
        super(personCustomerJpaRepository);
    }

}
