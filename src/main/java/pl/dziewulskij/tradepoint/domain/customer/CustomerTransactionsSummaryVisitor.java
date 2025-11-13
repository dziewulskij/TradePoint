package pl.dziewulskij.tradepoint.domain.customer;

import org.apache.commons.lang3.ObjectUtils;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

import java.math.BigDecimal;

public class CustomerTransactionsSummaryVisitor implements CustomerVisitor<CustomerTransactionsSummary> {

    @Override
    public CustomerTransactionsSummary visit(Customer customer) {
        BigDecimal buy = BigDecimal.ZERO;
        BigDecimal sell = BigDecimal.ZERO;

        for (Transaction tx : customer.getTransactions()) {
            if (ObjectUtils.anyNull(tx.getTotal(), tx.getTransactionType())) {
                continue;
            }

            switch (tx.getTransactionType()) {
                case BUY -> buy = buy.add(tx.getTotal().total());
                case SELL -> sell = sell.add(tx.getTotal().total());
            }
        }

        return new CustomerTransactionsSummary(buy, sell);
    }
}
