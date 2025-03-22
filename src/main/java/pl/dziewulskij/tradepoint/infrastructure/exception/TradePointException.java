package pl.dziewulskij.tradepoint.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TradePointException extends RuntimeException {

    private final ErrorCode errorCode;

}
