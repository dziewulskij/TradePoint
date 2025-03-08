package pl.dziewulskij.tradepoint.infrastructure.mail;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.MailSender;

@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {

    private final JavaMailSender javaMailSender;

    public void send(String subject, String recipient, String htmlContent) {
        Try.run(() -> trySend(subject, recipient, htmlContent))
                .getOrElseThrow(EmailSendingException::new);
    }

    @SneakyThrows
    private void trySend(String subject, String recipient, String htmlContent)  {
        var message = javaMailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(recipient);
        messageHelper.setSubject(subject);
        messageHelper.setText(htmlContent, true);

        javaMailSender.send(message);
    }

}
