package pl.dziewulskij.tradepoint.application.notification.port.out;

import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface MailSender {

    void send(String subject, String recipient, String htmlContent);

}
