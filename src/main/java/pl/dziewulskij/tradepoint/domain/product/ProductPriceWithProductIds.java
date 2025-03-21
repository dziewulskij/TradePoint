package pl.dziewulskij.tradepoint.domain.product;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.UUID;

public record ProductPriceWithProductIds(
        BusinessId productId,
        BusinessId productPriceId
) {

    public static ProductPriceWithProductIds of(UUID productId, UUID priceId) {
        return new ProductPriceWithProductIds(
                BusinessId.of(productId),
                BusinessId.of(priceId)
        );
    }

}
