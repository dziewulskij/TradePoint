package pl.dziewulskij.tradepoint.application.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.TransactionCustomerQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.out.customer.UserCustomersQueryPort;
import pl.dziewulskij.tradepoint.domain.customer.CustomerTransactionsSummary;
import pl.dziewulskij.tradepoint.domain.customer.CustomerTransactionsSummaryVisitor;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Service
@RequiredArgsConstructor
public class CustomerTransactionService implements TransactionCustomerQueryUseCase {

    private final UserCustomersQueryPort userCustomersQueryPort;

    @Override
    public CustomerTransactionsSummary getTransactionSummaryForCustomer(BusinessId customerId) {
        return userCustomersQueryPort.getByBusinessId(customerId)
                .map(customer -> customer.accept(new CustomerTransactionsSummaryVisitor()))
                .orElse(CustomerTransactionsSummary.empty());
    }
}
