package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.company;

import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.customer.CustomerRepositoryAdapter;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputAdapter;

@OutputAdapter
@Repository
public class CompanyCustomerRepositoryAdapter extends CustomerRepositoryAdapter<CompanyCustomer> {

    public CompanyCustomerRepositoryAdapter(CompanyCustomerJpaRepository companyCustomerJpaRepository) {
        super(companyCustomerJpaRepository);
    }

}
