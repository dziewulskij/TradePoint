package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

@Repository
@RequiredArgsConstructor
public class TransactionRepository implements SaveTransactionPort {

    private final TransactionJpaRepository transactionJpaRepository;

    @Override
    public void save(Transaction transaction) {
        transactionJpaRepository.save(transaction);
    }

}
