package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.decorator;

import lombok.RequiredArgsConstructor;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.MailMessage;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;

@RequiredArgsConstructor
public abstract class MailMessageDecorator implements MailMessage {

    protected final MailMessage wrappedMessage;

    @Override
    public String getSubject() {
        return wrappedMessage.getSubject();
    }

    @Override
    public String getContent(Map<String, String> params) {
        return wrappedMessage.getContent(params);
    }

    @Override
    public EmailType getType() {
        return wrappedMessage.getType();
    }
}
