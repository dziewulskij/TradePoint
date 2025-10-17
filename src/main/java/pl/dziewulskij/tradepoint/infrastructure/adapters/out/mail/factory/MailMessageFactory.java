package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.EmailTemplateDataNotFoundException;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateConfig;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MailMessageFactory {

    private final EmailTemplateConfig emailTemplateConfig;

    public MailMessage create(EmailType emailType) {
        EmailTemplateConfig.EmailTemplateData templateData = getTemplate(emailType);

        return switch (emailType) {
            case USER_CREATED -> new UserCreatedMailMessage(templateData.getSubject(), templateData.getPath());
            case PASSWORD_RESET_REQUEST ->
                    new ResetPasswordMailMessage(templateData.getSubject(), templateData.getPath());
            default -> throw new UnsupportedOperationException("Unsupported email type:" + emailType);
        };
    }

    private EmailTemplateConfig.EmailTemplateData getTemplate(EmailType emailType) {
        EmailTemplateConfig.EmailTemplateData emailTemplateData = emailTemplateConfig.getTemplates().get(emailType);
        if (Objects.isNull(emailTemplateData)) {
            throw new EmailTemplateDataNotFoundException(emailType);
        }
        return emailTemplateData;
    }
}
