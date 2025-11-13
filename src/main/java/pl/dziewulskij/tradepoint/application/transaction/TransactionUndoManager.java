package pl.dziewulskij.tradepoint.application.transaction;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

import java.util.*;

@Component
public class TransactionUndoManager {

    private final Map<BusinessId, Deque<Transaction.TransactionMemento>> history = new HashMap<>();

    public void saveState(Transaction transaction) {
        history
                .computeIfAbsent(transaction.getBusinessId(), id -> new ArrayDeque<>())
                .push(transaction.saveToMemento());
    }

    public void undo(Transaction transaction) {
        Deque<Transaction.TransactionMemento> stack = history.get(transaction.getBusinessId());
        if (Objects.isNull(stack) || stack.isEmpty()) {
            throw new IllegalStateException("No history for transaction " + transaction.getBusinessId());
        }
        Transaction.TransactionMemento memento = stack.pop();
        transaction.restoreFromMemento(memento);
    }
}
