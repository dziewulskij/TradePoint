package pl.dziewulskij.tradepoint.infrastructure.mail;

public class EmailTemplateLoadException extends RuntimeException {

    public EmailTemplateLoadException(Throwable thr) {
        super("Something went wrong current loading email template", thr);
    }

}
