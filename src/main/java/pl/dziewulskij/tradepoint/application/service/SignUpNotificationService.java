package pl.dziewulskij.tradepoint.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.MailSender;

@Component
@RequiredArgsConstructor
public class SignUpNotificationService {

    private final MailSender mailSender;

    public void sendNotification(String recipient) {
        mailSender.send("Subject1", recipient, "contenthtml");
    }

}
