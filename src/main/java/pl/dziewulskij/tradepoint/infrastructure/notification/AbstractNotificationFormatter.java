package pl.dziewulskij.tradepoint.infrastructure.notification;

import java.util.Map;

public abstract class AbstractNotificationFormatter implements NotificationFormatter {

    protected String applyTemplate(String template, Map<String, String> params) {
        for (var entry : params.entrySet()) {
            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return template;
    }

}
