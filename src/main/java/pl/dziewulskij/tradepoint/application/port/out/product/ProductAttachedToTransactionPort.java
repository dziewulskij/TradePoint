package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

public interface ProductAttachedToTransactionPort {

    boolean isProductAttachedToAnyTransaction(BusinessId productId);

}
