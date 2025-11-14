package pl.dziewulskij.tradepoint.infrastructure.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final List<NotificationChannel> channels;
    private final Map<String, NotificationSender> senders;

    public void notify(Channel channel, String recipient, String templateKey, Map<String, String> params) {

        boolean supported = channels.stream()
                .anyMatch(c -> c.supports(channel));

        if (!supported) {
            throw new IllegalArgumentException("No notification channel supports: " + channel);
        }

        NotificationSender sender = senders.get(channel.name());
        if (sender == null) {
            throw new IllegalStateException("No NotificationSender configured for channel: " + channel);
        }

        sender.send(recipient, templateKey, params);
    }
}
