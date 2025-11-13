package pl.dziewulskij.tradepoint.application.transaction.strategy;

import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionTotalType;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionTotalStrategy {

    BigDecimal calculateTotal(List<Transaction> transactions);

    TransactionTotalType getSupportedType();
}
