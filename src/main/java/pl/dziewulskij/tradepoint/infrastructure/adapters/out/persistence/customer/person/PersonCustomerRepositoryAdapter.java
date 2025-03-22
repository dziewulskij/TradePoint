package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.person;

import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.CustomerRepositoryAdapter;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

@OutputAdapter
@Repository
public class PersonCustomerRepositoryAdapter extends CustomerRepositoryAdapter<PersonCustomer> {

    public PersonCustomerRepositoryAdapter(PersonCustomerJpaRepository personCustomerJpaRepository) {
        super(personCustomerJpaRepository);
    }

}
