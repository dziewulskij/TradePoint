package pl.dziewulskij.tradepoint.application.transaction.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.transaction.TransactionExistencePort;
import pl.dziewulskij.tradepoint.domain.exception.TransactionNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class TransactionBelongToUserValidator {

    private final TransactionExistencePort transactionExistencePort;

    public void validate(BusinessId transactionId) {
        if (!transactionExistencePort.existsByIdAndUserId(transactionId, AuthenticationUtils.getCurrentUserId())) {
            throw new TransactionNotFoundException();
        }
    }

}
