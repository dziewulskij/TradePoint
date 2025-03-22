package pl.dziewulskij.tradepoint.application.transaction.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.customer.validator.CustomerBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommand;
import pl.dziewulskij.tradepoint.application.product.validator.ProductBelongToUserValidator;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class TransactionCommandValidatorFacade {

    private final CustomerBelongToUserValidator customerBelongToUserValidator;
    private final ProductBelongToUserValidator productBelongToUserValidator;
    private final TransactionBelongToUserValidator transactionBelongToUserValidator;
    private final TransactionDeletionValidator transactionDeletionValidator;

    public void validateForCreationOrUpdate(TransactionCommand command) {
        customerBelongToUserValidator.validate(command.customerId());
        productBelongToUserValidator.validate(command.productId());
    }

    public void validateForDeletion(BusinessId transactionId) {
        transactionBelongToUserValidator.validate(transactionId);
        transactionDeletionValidator.validate(transactionId);
    }

}
