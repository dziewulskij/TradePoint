package pl.dziewulskij.tradepoint.infrastructure.mail;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailTemplateConfig {

    USER_CREATED("templates/mail/registration_email.html", "Witamy w TradePoint!");

    private final String path;
    private final String subject;

}
