package pl.dziewulskij.tradepoint.application.password.event.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.MailSender;
import pl.dziewulskij.tradepoint.domain.password.PasswordResetRequestEvent;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.MailParamName;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PasswordResetRequestEventListener {

    private static final EmailType EMAIL_TYPE = EmailType.PASSWORD_RESET_REQUEST;

    private final MailSender mailSender;

    @Async
    @EventListener
    public void onPasswordResetRequest(PasswordResetRequestEvent event) {
        Map<String, String> mailParams = Map.of(MailParamName.TOKEN, event.token().toString());
        mailSender.send(EMAIL_TYPE, event.email(), mailParams);
    }

}
