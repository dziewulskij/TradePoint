package pl.dziewulskij.tradepoint.application.product.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.product.ProductPriceExistencePort;
import pl.dziewulskij.tradepoint.domain.exception.ProductPriceNotFoundException;
import pl.dziewulskij.tradepoint.domain.product.ProductPriceWithProductIds;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class ProductPriceBelongToUserValidator {

    private final ProductPriceExistencePort productPriceExistencePort;

    public void validate(ProductPriceWithProductIds productPriceWithProductIds) {
        boolean exists = productPriceExistencePort.existsByIdAndUserId(
                productPriceWithProductIds.productPriceId(),
                AuthenticationUtils.getCurrentUserId()
        );

        if (!exists) {
            throw new ProductPriceNotFoundException();
        }
    }

}
