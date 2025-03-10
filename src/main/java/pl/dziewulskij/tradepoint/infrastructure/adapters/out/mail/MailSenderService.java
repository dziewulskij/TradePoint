package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.notification.port.out.MailSender;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateConfig;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateLoader;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {

    private final JavaMailSender javaMailSender;
    private final EmailTemplateConfig emailTemplateConfig;

    public void send(String subject, String recipient, String htmlContent) {
        Try.run(() -> trySend(subject, recipient, htmlContent))
                .getOrElseThrow(EmailSendingException::new);
    }

    public void send(EmailType emailType, Email recipient) {
        EmailTemplateConfig.EmailTemplateData emailTemplateData = emailTemplateConfig.getTemplates().get(emailType);
        String content = EmailTemplateLoader.load(emailTemplateData.getPath());
        Try.run(() -> trySend(
                        emailTemplateData.getSubject(),
                        recipient.value(),
                        content
                ))
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
