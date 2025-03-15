package pl.dziewulskij.tradepoint.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductExistencePort;
import pl.dziewulskij.tradepoint.domain.exception.ProductAlreadyExistsException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class ProductNameUniquenessValidator {

    private final ProductExistencePort productExistencePort;

    void validateForCreation(String productName) {
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();

        if (productExistencePort.existsByNameAndUserId(productName, currentUserId)) {
            throw new ProductAlreadyExistsException();
        }
    }

    void validateForUpdate(String productName, BusinessId productId) {
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();

        if (productExistencePort.existsByNameAndUserIdExcludingProductId(productName, currentUserId, productId)) {
            throw new ProductAlreadyExistsException();
        }
    }

}
