package pl.dziewulskij.tradepoint.application.port.out.transaction;

import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

public interface SaveTransactionPort {

    void save(Transaction transaction);

}
