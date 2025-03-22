package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.dziewulskij.tradepoint.application.port.out.transaction.SaveTransactionPort;
import pl.dziewulskij.tradepoint.application.port.out.transaction.TransactionExistencePort;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.info.TransactionOverviewInfo;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransactionRepository implements SaveTransactionPort, LoadTransactionCompositePort, TransactionExistencePort {

    private final TransactionJpaRepository transactionJpaRepository;

    @Override
    public void save(Transaction transaction) {
        transactionJpaRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findByBusinessId(BusinessId transactionId) {
        return transactionJpaRepository.findByBusinessId(transactionId);
    }

    @Override
    public Optional<Transaction> findByBusinessIdFetchProductAndCustomer(BusinessId transactionId) {
        return transactionJpaRepository.findByBusinessIdFetchProductAndCustomer(transactionId);
    }

    @Override
    public boolean existsByIdAndUserId(BusinessId transactionId, BusinessId userId) {
        return transactionJpaRepository.existsByBusinessIdAndUserBusinessId(transactionId, userId);
    }

    @Override
    public List<TransactionOverviewInfo> findAll(BusinessId userId) {
        return transactionJpaRepository.findTransactionOverviewInfoByUserId(userId);
    }
}
