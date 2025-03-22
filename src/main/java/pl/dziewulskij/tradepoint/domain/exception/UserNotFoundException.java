package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class UserNotFoundException extends TradePointException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
