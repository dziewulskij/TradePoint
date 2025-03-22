package pl.dziewulskij.tradepoint.infrastructure.exception;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record ErrorDetails(@NonNull LocalDateTime timestamp,
                           @NonNull Set<String> errorCodes,
                           @NonNull HttpStatus status) {

    public static ErrorDetails of(ErrorCode errorCode) {
        return ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .errorCodes(Set.of(errorCode.getCode()))
                .status(errorCode.getStatus())
                .build();
    }

    public static ErrorDetails of(Set<ErrorCode> errorCodes, HttpStatus httpStatus) {
        return ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .errorCodes(extractCodes(errorCodes))
                .status(httpStatus)
                .build();
    }

    private static Set<String> extractCodes(Set<ErrorCode> errorCodes) {
        return errorCodes.stream()
                .map(ErrorCode::getCode)
                .collect(Collectors.toSet());
    }

}
