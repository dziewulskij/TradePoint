package pl.dziewulskij.tradepoint.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionAdvisor {

    @ExceptionHandler(TradePointException.class)
    public ResponseEntity<ErrorDetails> handleTradePointException(TradePointException exception) {
        var errorDetails = ErrorDetails.of(exception.getErrorCode());
        return ResponseEntity
                .status(errorDetails.status())
                .body(errorDetails);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<Object> handleUnsupportedOperationException() {
        return ResponseEntity.badRequest().build();
    }
}
