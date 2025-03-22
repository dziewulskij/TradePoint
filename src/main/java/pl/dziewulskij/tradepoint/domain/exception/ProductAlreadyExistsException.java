package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class ProductAlreadyExistsException extends TradePointException {

    public ProductAlreadyExistsException() {
        super(ErrorCode.PRODUCT_ALREADY_EXISTS);
    }
}
