package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class PasswordResetNotFoundException extends TradePointException {

    public PasswordResetNotFoundException() {
        super(ErrorCode.PASSWORD_RESET_NOT_FOUND);
    }
}
