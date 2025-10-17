package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.out.mail.MailSender;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.MailMessage;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.decorator.AttachmentMailMessageDecorator;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.factory.MailMessageFactory;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {

    private final JavaMailSender javaMailSender;
    private final MailMessageFactory mailMessageFactory;

    public void send(EmailType emailType, Email recipient) {
        MailMessage mailMessage = mailMessageFactory.create(emailType);
        sendMail(mailMessage.getSubject(), recipient.value(), mailMessage.getContent(Collections.emptyMap()), null);
    }

    public void send(EmailType emailType, Email recipient, File file) {
        MailMessage mailMessage = mailMessageFactory.create(emailType);
        AttachmentMailMessageDecorator mailMessageDecorator = new AttachmentMailMessageDecorator(mailMessage, file);
        sendMail(
                mailMessageDecorator.getSubject(),
                recipient.value(),
                mailMessageDecorator.getContent(Collections.emptyMap()),
                mailMessageDecorator.getAttachment()
        );
    }

    public void send(EmailType emailType, Email recipient, Map<String, String> params) {
        MailMessage mailMessage = mailMessageFactory.create(emailType);
        sendMail(mailMessage.getSubject(), recipient.value(), mailMessage.getContent(params), null);
    }

    private void sendMail(String subject, String recipient, String htmlContent, File attachement) {
        Try.run(() -> trySend(subject, recipient, htmlContent, attachement))
                .getOrElseThrow(EmailSendingException::new);
    }

    @SneakyThrows
    private void trySend(String subject, String recipient, String htmlContent, File attachement) {
        var message = javaMailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(recipient);
        messageHelper.setSubject(subject);
        messageHelper.setText(htmlContent, true);

        if (Objects.nonNull(attachement)) {
            messageHelper.addAttachment(attachement.getName(), attachement);
        }

        javaMailSender.send(message);
    }

}
