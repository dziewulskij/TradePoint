package pl.dziewulskij.tradepoint.application.port.in.transaction;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface TransactionCommandUseCase {

    TransactionResult create(TransactionCommand command);

    TransactionResult update(BusinessId id, TransactionCommand command);
}
