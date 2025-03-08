package pl.dziewulskij.tradepoint.application.port;

public interface MailSender {

    void send(String subject, String recipient, String htmlContent);

}
