package pl.dziewulskij.tradepoint.infrastructure.notification;

import java.util.Map;

public interface NotificationFormatter {

    String format(String templateKey, Map<String, String> params);
}
