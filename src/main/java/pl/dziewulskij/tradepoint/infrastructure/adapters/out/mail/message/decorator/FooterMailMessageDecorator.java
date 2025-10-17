package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.decorator;

import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.MailMessage;

import java.util.Map;

public class FooterMailMessageDecorator extends MailMessageDecorator {

    private final String footer;

    public FooterMailMessageDecorator(MailMessage wrappedMessage, String footer) {
        super(wrappedMessage);
        this.footer = footer;
    }

    @Override
    public String getContent(Map<String, String> params) {
        return super.getContent(params) + "\n\n" + footer;
    }
}
