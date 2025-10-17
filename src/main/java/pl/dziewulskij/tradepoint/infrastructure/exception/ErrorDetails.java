package pl.dziewulskij.tradepoint.infrastructure.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static ErrorDetailsBuilder builder() {
        return new ErrorDetailsBuilder();
    }

    public static class ErrorDetailsBuilder {
        private LocalDateTime timestamp;
        private Set<String> errorCodes;
        private HttpStatus status;

        ErrorDetailsBuilder() {
        }

        public ErrorDetailsBuilder timestamp(@NonNull LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder errorCodes(@NonNull Set<String> errorCodes) {
            this.errorCodes = errorCodes;
            return this;
        }

        public ErrorDetailsBuilder status(@NonNull HttpStatus status) {
            this.status = status;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(this.timestamp, this.errorCodes, this.status);
        }

        public String toString() {
            return "ErrorDetails.ErrorDetailsBuilder(timestamp=" + this.timestamp
                    + ", errorCodes=" + this.errorCodes
                    + ", status=" + this.status
                    + ")";
        }
    }
}
