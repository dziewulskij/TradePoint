package pl.dziewulskij.tradepoint.application.transaction.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadTransactionPort;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

@Component
@RequiredArgsConstructor
public class TransactionDeletionValidator {

    private final LoadTransactionPort loadTransactionPort;

    public void validate(BusinessId transactionId) {
        loadTransactionPort.findByBusinessId(transactionId)
                .ifPresent(Transaction::validateDeletable);
    }

}
