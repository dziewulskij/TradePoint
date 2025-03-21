package pl.dziewulskij.tradepoint.application.product.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Service
@RequiredArgsConstructor
public class ProductCommandValidatorFacade {

    private final ProductNameUniquenessValidator productNameUniquenessValidator;
    private final ProductBelongToUserValidator productBelongToUserValidator;
    private final ProductNotAttachedValidator productNotAttachedValidator;

    public void validateForCreation(String productName) {
        productNameUniquenessValidator.validateForCreation(productName);
    }

    public void validateForDeletion(BusinessId productId) {
        productBelongToUserValidator.validate(productId);
        productNotAttachedValidator.validate(productId);
    }

}
