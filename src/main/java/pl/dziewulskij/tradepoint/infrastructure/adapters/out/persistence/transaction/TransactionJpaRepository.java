package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.info.TransactionOverviewInfo;

import java.util.List;
import java.util.Optional;

public interface TransactionJpaRepository extends JpaRepository<Transaction, Long> {

    boolean existsByProductBusinessId(BusinessId productId);

    Optional<Transaction> findByBusinessId(BusinessId businessId);

    boolean existsByBusinessIdAndUserBusinessId(BusinessId businessId, BusinessId businessId1);

    @Query("select t from Transaction t join fetch t.product join fetch t.customer where t.businessId=:transactionId")
    Optional<Transaction> findByBusinessIdFetchProductAndCustomer(BusinessId transactionId);

    @Query("""
            select
                t.businessId as id,
                p.name as productName,
                p.unit as productUnit,
                c.customerType as customerType,
                c.firstName as customerFirstName,
                c.lastName as customerLastName,
                c.companyName as customerCompanyName,
                t.transactionType as transactionType,
                t.paymentType as paymentType,
                t.paymentStatus as paymentStatus,
                t.total as total,
                t.transactionDate as transactionDate
            from Transaction t
            join t.product p
            join t.customer c
            join t.user u
            where u.businessId = :userId
            """)
    List<TransactionOverviewInfo> findTransactionOverviewInfoByUserId(BusinessId userId);
}
