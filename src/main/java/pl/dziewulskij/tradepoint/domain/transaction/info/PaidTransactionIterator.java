package pl.dziewulskij.tradepoint.domain.transaction.info;

import lombok.AllArgsConstructor;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class PaidTransactionIterator implements Iterator<TransactionOverviewInfo> {

    private final List<TransactionOverviewInfo> transactions;
    private int position = 0;

    public PaidTransactionIterator(List<TransactionOverviewInfo> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean hasNext() {
        while (position < transactions.size()) {
            if (transactions.get(position).getPaymentStatus() == PaymentStatus.PAID) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public TransactionOverviewInfo next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return transactions.get(position++);
    }
}
