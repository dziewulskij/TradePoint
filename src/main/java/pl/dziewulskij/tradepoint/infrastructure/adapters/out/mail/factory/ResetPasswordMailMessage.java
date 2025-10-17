package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory;

import lombok.AllArgsConstructor;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.MailTemplateParamReplacer;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateLoader;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;

@AllArgsConstructor
public class ResetPasswordMailMessage implements MailMessage {

    private final String subject;
    private final String templatePath;

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getContent(Map<String, String> params) {
        String template = EmailTemplateLoader.load(templatePath);
        return MailTemplateParamReplacer.replace(template, params);
    }

    @Override
    public EmailType getType() {
        return EmailType.PASSWORD_RESET_REQUEST;
    }
}
