package pl.dziewulskij.tradepoint.application.port.in.transaction;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

@InputPort
public interface TransactionCommandUseCase {

    TransactionResult create(CreateTransactionCommand command);

}
