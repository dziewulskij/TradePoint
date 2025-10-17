package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory;

import lombok.AllArgsConstructor;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateLoader;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;

@AllArgsConstructor
public class UserCreatedMailMessage implements MailMessage {

    private final String subject;
    private final String templatePath;

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getContent(Map<String, String> params) {
        return EmailTemplateLoader.load(templatePath);
    }

    @Override
    public EmailType getType() {
        return EmailType.USER_CREATED;
    }
}
