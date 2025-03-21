package pl.dziewulskij.tradepoint.application.product.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductExistencePort;
import pl.dziewulskij.tradepoint.domain.exception.ProductNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class ProductBelongToUserValidator {

    private final ProductExistencePort productExistencePort;

    public void validate(BusinessId productId) {
        boolean exists = productExistencePort.existsByIdAndUserId(productId, AuthenticationUtils.getCurrentUserId());

        if (!exists) {
            throw new ProductNotFoundException();
        }
    }

}
