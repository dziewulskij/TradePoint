package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

public class EmailSendingException extends RuntimeException {

    public EmailSendingException(Throwable cause) {
        super(cause);
    }

}
