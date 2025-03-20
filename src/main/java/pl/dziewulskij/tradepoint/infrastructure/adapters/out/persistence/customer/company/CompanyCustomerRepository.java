package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.company;

import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.CustomerRepository;

@Repository
public class CompanyCustomerRepository extends CustomerRepository<CompanyCustomer> {

    public CompanyCustomerRepository(CompanyCustomerJpaRepository companyCustomerJpaRepository) {
        super(companyCustomerJpaRepository);
    }

}
