package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadOverviewTransactionPort;
import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadTransactionPort;

public interface LoadTransactionCompositePort extends LoadTransactionPort, LoadOverviewTransactionPort {
}
