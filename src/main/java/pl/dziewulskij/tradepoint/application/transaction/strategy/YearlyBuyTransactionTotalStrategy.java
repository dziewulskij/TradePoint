package pl.dziewulskij.tradepoint.application.transaction.strategy;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.domain.shared.TransactionTotal;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionTotalType;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class YearlyBuyTransactionTotalStrategy implements TransactionTotalStrategy {

    @Override
    public BigDecimal calculateTotal(List<Transaction> transactions) {
        return CollectionUtils.emptyIfNull(transactions)
                .stream()
                .filter(tx -> tx.getTransactionType() == TransactionType.BUY)
                .filter(tx -> tx.getTransactionDate().isAfter(getYearAgo()))
                .map(Transaction::getTotal)
                .map(TransactionTotal::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public TransactionTotalType getSupportedType() {
        return TransactionTotalType.BUY_YEARLY;
    }

    private LocalDateTime getYearAgo() {
        return LocalDate.now()
                .minusYears(1)
                .atStartOfDay();
    }
}
