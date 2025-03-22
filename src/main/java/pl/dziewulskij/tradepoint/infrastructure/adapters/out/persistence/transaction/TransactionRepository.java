package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadTransactionPort;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransactionRepository implements SaveTransactionPort, LoadTransactionPort {

    private final TransactionJpaRepository transactionJpaRepository;

    @Override
    public void save(Transaction transaction) {
        transactionJpaRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> getByBusinessId(BusinessId transactionId) {
        return transactionJpaRepository.findByBusinessId(transactionId);
    }
}
