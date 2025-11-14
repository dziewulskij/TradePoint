package pl.dziewulskij.tradepoint.application.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.TransactionTotalCalculateUseCase;
import pl.dziewulskij.tradepoint.application.transaction.strategy.MonthlyBuyTransactionTotalStrategy;
import pl.dziewulskij.tradepoint.application.transaction.strategy.MonthlySellTransactionTotalStrategy;
import pl.dziewulskij.tradepoint.application.transaction.strategy.TransactionTotalStrategy;
import pl.dziewulskij.tradepoint.application.transaction.strategy.YearlyBuyTransactionTotalStrategy;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionTotalType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TransactionTotalCalculatorService implements TransactionTotalCalculateUseCase {

    private final TransactionProvider transactionProvider;

    @Override
    public Map<TransactionTotalType, BigDecimal> calculate(BusinessId customerId) {
        List<Transaction> customerTransactions = transactionProvider.allByCustomerId(customerId);

        TransactionTotalStrategy buyMonthlyTotalStrategy = new MonthlyBuyTransactionTotalStrategy();
        TransactionTotalStrategy sellMonthlyTotalStrategy = new MonthlySellTransactionTotalStrategy();
        TransactionTotalStrategy buyYearlyTotalStrategy = new YearlyBuyTransactionTotalStrategy();

        return Map.of(
                TransactionTotalType.BUY_MONTHLY, buyMonthlyTotalStrategy.calculateTotal(customerTransactions),
                TransactionTotalType.SELL_MONTHLY, sellMonthlyTotalStrategy.calculateTotal(customerTransactions),
                TransactionTotalType.BUY_YEARLY, buyYearlyTotalStrategy.calculateTotal(customerTransactions)
        );
    }
}
