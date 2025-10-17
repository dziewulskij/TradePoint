package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.factory;

import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

import java.util.Map;

public interface MailMessage {
    String getSubject();

    String getContent(Map<String, String> params);

    EmailType getType();
}
