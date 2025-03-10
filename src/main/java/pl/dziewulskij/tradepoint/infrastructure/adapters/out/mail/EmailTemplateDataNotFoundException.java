package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

public class EmailTemplateDataNotFoundException extends RuntimeException {

    public EmailTemplateDataNotFoundException(EmailType emailType) {
        super("Email template data not found for email type: " + emailType);
    }
}
