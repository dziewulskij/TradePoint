
package pl.dziewulskij.tradepoint.infrastructure.notification;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public abstract class AbstractNotificationSender implements NotificationSender {

    protected final NotificationFormatter formatter;

    protected String format(String templateKey, Map<String, String> params) {
        return formatter.format(templateKey, params);
    }
}
