package pl.dziewulskij.tradepoint.infrastructure.notification;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsNotificationSender extends AbstractNotificationSender {

    public SmsNotificationSender(NotificationFormatter formatter) {
        super(formatter);
    }

    @Override
    public void send(String to, String templateKey, Map<String, String> params) {
        String message = format(templateKey, params);
        // Real implementation
        System.out.println("SMS -> " + to + ": " + message);
    }
}
