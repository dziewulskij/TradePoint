package pl.dziewulskij.tradepoint.infrastructure.mail;

public class EmailSendingException extends RuntimeException {

    public EmailSendingException(Throwable cause) {
        super(cause);
    }

}
