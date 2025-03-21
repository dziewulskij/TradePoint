package pl.dziewulskij.tradepoint.application.port.out.customer;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface CustomerExistencePort {

    boolean existsByIdAndUserId(BusinessId customerId, BusinessId userId);

}
