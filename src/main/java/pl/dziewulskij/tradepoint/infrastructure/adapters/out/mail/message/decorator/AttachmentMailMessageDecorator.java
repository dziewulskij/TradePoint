package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.decorator;

import lombok.Getter;
import pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail.message.MailMessage;

import java.io.File;

@Getter
public class AttachmentMailMessageDecorator extends MailMessageDecorator {

    private final File attachment;

    public AttachmentMailMessageDecorator(MailMessage wrappedMessage, File attachment) {
        super(wrappedMessage);
        this.attachment = attachment;
    }

    @Override
    public String getSubject() {
        return super.getSubject() + " - " + attachment.getName();
    }
}
