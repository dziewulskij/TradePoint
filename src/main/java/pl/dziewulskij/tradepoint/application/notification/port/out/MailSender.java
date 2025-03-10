package pl.dziewulskij.tradepoint.application.notification.port.out;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

@OutputPort
public interface MailSender {

    void send(String subject, String recipient, String htmlContent);

    void send(EmailType emailType, Email recipient);

}
