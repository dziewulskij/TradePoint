package pl.dziewulskij.tradepoint.application.product.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductAttachedToTransactionPort;
import pl.dziewulskij.tradepoint.domain.exception.ProductAttachedToTransactionException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class ProductNotAttachedValidator {

    private final ProductAttachedToTransactionPort productAttachedToTransactionPort;

    public void validate(BusinessId productId) {
        boolean attachedToAnyTransaction = productAttachedToTransactionPort.isProductAttachedToAnyTransaction(productId);

        if (attachedToAnyTransaction) {
            throw new ProductAttachedToTransactionException();
        }
    }

}
