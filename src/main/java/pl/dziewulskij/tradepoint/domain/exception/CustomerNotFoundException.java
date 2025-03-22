package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class CustomerNotFoundException extends TradePointException {

    public CustomerNotFoundException() {
        super(ErrorCode.CUSTOMER_NOT_FOUND);
    }
}
