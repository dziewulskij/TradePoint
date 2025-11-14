package pl.dziewulskij.tradepoint.infrastructure.notification;

public interface NotificationChannel {
    boolean supports(Channel channel);
}
