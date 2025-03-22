package pl.dziewulskij.tradepoint.domain.exception;

import pl.dziewulskij.tradepoint.infrastructure.exception.ErrorCode;
import pl.dziewulskij.tradepoint.infrastructure.exception.TradePointException;

public class TransactionCannotDeletePaidException extends TradePointException {

    public TransactionCannotDeletePaidException() {
        super(ErrorCode.TRANSACTION_CANNOT_DELETE_PAID);
    }
}
