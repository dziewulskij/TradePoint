package pl.dziewulskij.tradepoint.application.port.in.customer.query;

import pl.dziewulskij.tradepoint.domain.customer.CustomerTransactionsSummary;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface TransactionCustomerQueryUseCase {

    CustomerTransactionsSummary getTransactionSummaryForCustomer(BusinessId customerId);

}
