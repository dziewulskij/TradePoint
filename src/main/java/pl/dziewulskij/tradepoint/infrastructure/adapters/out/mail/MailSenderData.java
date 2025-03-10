package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import pl.dziewulskij.tradepoint.domain.shared.Email;
import pl.dziewulskij.tradepoint.infrastructure.mail.EmailType;

public record MailSenderData(EmailType emailType, Email recipient) {
}
