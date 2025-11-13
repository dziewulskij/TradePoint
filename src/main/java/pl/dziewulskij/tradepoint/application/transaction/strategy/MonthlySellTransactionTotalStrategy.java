package pl.dziewulskij.tradepoint.application.transaction.strategy;

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
public class MonthlySellTransactionTotalStrategy implements TransactionTotalStrategy {

    @Override
    public BigDecimal calculateTotal(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tx -> tx.getTransactionType() == TransactionType.SELL)
                .filter(tx -> tx.getTransactionDate().isAfter(getMonthAgo()))
                .map(Transaction::getTotal)
                .map(TransactionTotal::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public TransactionTotalType getSupportedType() {
        return TransactionTotalType.SELL_MONTHLY;
    }

    private LocalDateTime getMonthAgo() {
        return LocalDate.now()
                .minusMonths(1)
                .atStartOfDay();
    }
}
