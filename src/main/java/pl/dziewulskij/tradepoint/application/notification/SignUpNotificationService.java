package pl.dziewulskij.tradepoint.application.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.MailSender;

@Component
@RequiredArgsConstructor
public class SignUpNotificationService {

    private final MailSender mailSender;

    public void sendNotification(String recipient) {
    }

}
