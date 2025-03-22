package pl.dziewulskij.tradepoint.application.port.out.transaction;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface TransactionExistencePort {

    boolean existsByIdAndUserId(BusinessId transactionId, BusinessId userId);

}
