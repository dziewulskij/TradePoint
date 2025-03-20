package pl.dziewulskij.tradepoint.application.port.in.customer.command;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface CustomerCommandUseCase {

    CommandCustomerResult create(CustomerCommand command);

    CommandCustomerResult update(BusinessId id, CustomerCommand command);

}
