package pl.dziewulskij.tradepoint.infrastructure.notification;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsFormatter extends AbstractNotificationFormatter {

    @Override
    public String format(String templateKey, Map<String, String> params) {
        return applyTemplate("Hello {{name}}, you have a new SMS notification!", params);
    }
}
