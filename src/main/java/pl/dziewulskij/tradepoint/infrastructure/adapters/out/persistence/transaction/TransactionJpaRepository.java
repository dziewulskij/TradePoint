package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

public interface TransactionJpaRepository extends JpaRepository<Transaction, Long> {
}
