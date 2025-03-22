package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

import java.util.Optional;

public interface TransactionJpaRepository extends JpaRepository<Transaction, Long> {

    boolean existsByProductBusinessId(BusinessId productId);

    Optional<Transaction> findByBusinessId(BusinessId businessId);
}
