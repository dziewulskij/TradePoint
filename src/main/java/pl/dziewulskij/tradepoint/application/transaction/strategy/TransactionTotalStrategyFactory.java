package pl.dziewulskij.tradepoint.application.transaction.strategy;

import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionTotalType;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransactionTotalStrategyFactory {

    private final Map<TransactionTotalType, TransactionTotalStrategy> strategies;

    public TransactionTotalStrategyFactory(Set<TransactionTotalStrategy> strategies) {
        this.strategies = strategies.stream()
                .collect(Collectors.toMap(TransactionTotalStrategy::getSupportedType, s -> s));
    }

    public TransactionTotalStrategy getStrategy(TransactionTotalType type) {
        TransactionTotalStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for type: " + type);
        }
        return strategy;
    }
}
