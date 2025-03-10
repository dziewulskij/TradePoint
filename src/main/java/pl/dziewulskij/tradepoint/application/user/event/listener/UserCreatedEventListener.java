package pl.dziewulskij.tradepoint.application.user.event.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.notification.port.out.MailSender;
import pl.dziewulskij.tradepoint.domain.user.UserCreatedEvent;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.MailSenderData;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateConfig;

@Component
@RequiredArgsConstructor
public class UserCreatedEventListener {

    private static final EmailTemplateConfig EMAIL_TEMPLATE_CONFIG = EmailTemplateConfig.USER_CREATED;

    private final MailSender mailSender;

    @Async
    @EventListener
    public void onUserCreated(UserCreatedEvent event) {
        mailSender.send(new MailSenderData(EMAIL_TEMPLATE_CONFIG, event.email()));
    }

}
