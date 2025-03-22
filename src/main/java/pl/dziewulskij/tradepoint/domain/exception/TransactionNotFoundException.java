package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class TransactionNotFoundException extends TradePointException {

    public TransactionNotFoundException() {
        super(ErrorCode.TRANSACTION_NOT_FOUND);
    }
}
