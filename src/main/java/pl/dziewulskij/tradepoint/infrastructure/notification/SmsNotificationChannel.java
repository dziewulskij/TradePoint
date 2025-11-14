package pl.dziewulskij.tradepoint.infrastructure.notification;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationChannel extends AbstractNotificationChannel {

    public SmsNotificationChannel() {
        super(Channel.SMS);
    }
}
