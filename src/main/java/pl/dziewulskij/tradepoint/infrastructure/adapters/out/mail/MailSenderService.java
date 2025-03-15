package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.out.mail.MailSender;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateConfig;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateLoader;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {

    private final JavaMailSender javaMailSender;
    private final EmailTemplateConfig emailTemplateConfig;

    public void send(EmailType emailType, Email recipient) {
        EmailTemplateConfig.EmailTemplateData emailTemplateData = getTemplate(emailType);
        String content = EmailTemplateLoader.load(emailTemplateData.getPath());
        sendMail(emailTemplateData.getSubject(), recipient.value(), content);
    }

    public void send(EmailType emailType, Email recipient, Map<String, String> params) {
        EmailTemplateConfig.EmailTemplateData emailTemplateData = getTemplate(emailType);
        String template = EmailTemplateLoader.load(emailTemplateData.getPath());
        String finalContent = MailTemplateParamReplacer.replace(template, params);
        sendMail(emailTemplateData.getSubject(), recipient.value(), finalContent);
    }

    private EmailTemplateConfig.EmailTemplateData getTemplate(EmailType emailType) {
        EmailTemplateConfig.EmailTemplateData emailTemplateData = emailTemplateConfig.getTemplates().get(emailType);
        if (Objects.isNull(emailTemplateData)) {
            throw new EmailTemplateDataNotFoundException(emailType);
        }
        return emailTemplateData;
    }

    private void sendMail(String subject, String recipient, String htmlContent) {
        Try.run(() -> trySend(subject, recipient, htmlContent))
                .getOrElseThrow(EmailSendingException::new);
    }

    @SneakyThrows
    private void trySend(String subject, String recipient, String htmlContent) {
        var message = javaMailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(recipient);
        messageHelper.setSubject(subject);
        messageHelper.setText(htmlContent, true);

        javaMailSender.send(message);
    }

}
