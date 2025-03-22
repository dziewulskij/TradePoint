package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class ProductPriceNotFoundException extends TradePointException {

    public ProductPriceNotFoundException() {
        super(ErrorCode.PRODUCT_PRICE_NOT_FOUND);
    }
}
