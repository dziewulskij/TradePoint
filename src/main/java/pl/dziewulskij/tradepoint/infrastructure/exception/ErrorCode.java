package pl.dziewulskij.tradepoint.infrastructure.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ErrorCode {

    CUSTOMER_NOT_FOUND("customer.not.found.error", HttpStatus.NOT_FOUND),
    PASSWORD_RESET_NOT_FOUND("password.reset.not.found.error", HttpStatus.NOT_FOUND),
    PRODUCT_ALREADY_EXISTS("product.already.exists.error", HttpStatus.CONFLICT),
    PRODUCT_ATTACHED_TO_TRANSACTION("product.attached.to.transaction.error", HttpStatus.CONFLICT),
    PRODUCT_NOT_FOUND("product.not.found.error", HttpStatus.NOT_FOUND),
    PRODUCT_PRICE_NOT_FOUND("product.price.not.found.error", HttpStatus.NOT_FOUND),
    TRANSACTION_CANNOT_DELETE_PAID("transaction.cannot.delete.paid.error", HttpStatus.BAD_REQUEST),
    TRANSACTION_NOT_FOUND("transaction.not.found.error", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("user.already.exists.error", HttpStatus.CONFLICT),
    USER_NOT_FOUND("user.not.found.error", HttpStatus.NOT_FOUND);

    String code;
    HttpStatus status;

}
