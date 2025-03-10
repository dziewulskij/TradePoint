package pl.dziewulskij.tradepoint.application.user.event.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.notification.port.out.MailSender;
import pl.dziewulskij.tradepoint.domain.user.UserCreatedEvent;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

@Component
@RequiredArgsConstructor
public class UserCreatedEventListener {

    private static final EmailType EMAIL_TYPE = EmailType.USER_CREATED;

    private final MailSender mailSender;

    @Async
    @EventListener
    public void onUserCreated(UserCreatedEvent event) {
        mailSender.send(EMAIL_TYPE, event.email());
    }

}
