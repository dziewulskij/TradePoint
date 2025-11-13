package pl.dziewulskij.tradepoint.domain.transaction.info;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class PaidTransactionOverviewCollection implements Iterable<TransactionOverviewInfo> {

    private final List<TransactionOverviewInfo> transactions;

    @Override
    public Iterator<TransactionOverviewInfo> iterator() {
        return new PaidTransactionIterator(transactions);
    }
}
