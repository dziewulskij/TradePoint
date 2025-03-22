package pl.dziewulskij.tradepoint.application.port.out.transaction;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

import java.util.Optional;

public interface LoadTransactionPort {

    Optional<Transaction> getByBusinessId(BusinessId transactionId);

}
