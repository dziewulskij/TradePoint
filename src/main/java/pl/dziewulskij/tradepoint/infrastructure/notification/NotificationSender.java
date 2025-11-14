package pl.dziewulskij.tradepoint.infrastructure.notification;

import java.util.Map;

public interface NotificationSender {
    void send(String to, String templateKey, Map<String, String> params);
}
