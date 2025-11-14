package pl.dziewulskij.tradepoint.infrastructure.notification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractNotificationChannel implements NotificationChannel {

    protected final Channel channel;

    @Override
    public boolean supports(Channel channel) {
        return this.channel == channel;
    }
}
