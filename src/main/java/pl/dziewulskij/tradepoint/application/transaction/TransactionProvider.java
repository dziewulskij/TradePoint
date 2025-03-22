package pl.dziewulskij.tradepoint.application.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadTransactionPort;
import pl.dziewulskij.tradepoint.domain.exception.TransactionNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

@Component
@RequiredArgsConstructor
public class TransactionProvider {

    private final LoadTransactionPort loadTransactionPort;

    public Transaction byBusinessId(BusinessId transactionId) {
        return loadTransactionPort.findByBusinessId(transactionId)
                .orElseThrow(TransactionNotFoundException::new);
    }

    public Transaction byBusinessIdFetchProductAndCustomer(BusinessId transactionId) {
        return loadTransactionPort.findByBusinessIdFetchProductAndCustomer(transactionId)
                .orElseThrow(TransactionNotFoundException::new);
    }

}
