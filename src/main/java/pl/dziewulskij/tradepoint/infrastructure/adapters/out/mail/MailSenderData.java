package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailTemplateConfig;

public record MailSenderData(EmailTemplateConfig emailTemplateConfig, Email recipient) {
}
