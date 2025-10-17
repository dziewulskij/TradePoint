package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.out.mail.MailSender;
import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory.MailMessage;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory.MailMessageFactory;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {

    private final JavaMailSender javaMailSender;
    private final MailMessageFactory mailMessageFactory;

    public void send(EmailType emailType, Email recipient) {
        MailMessage mailMessage = mailMessageFactory.create(emailType);
        sendMail(mailMessage.getSubject(), recipient.value(), mailMessage.getContent(Collections.emptyMap()));
    }

    public void send(EmailType emailType, Email recipient, Map<String, String> params) {
        MailMessage mailMessage = mailMessageFactory.create(emailType);
        sendMail(mailMessage.getSubject(), recipient.value(), mailMessage.getContent(params));
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
