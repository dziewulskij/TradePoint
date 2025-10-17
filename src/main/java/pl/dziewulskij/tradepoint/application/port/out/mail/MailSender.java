package pl.dziewulskij.tradepoint.application.port.out.mail;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.io.File;
import java.util.Map;

@OutputPort
public interface MailSender {

    void send(EmailType emailType, Email recipient);

    void send(EmailType emailType, Email recipient, File attachment);

    void send(EmailType emailType, Email recipient, Map<String, String> params);

}
