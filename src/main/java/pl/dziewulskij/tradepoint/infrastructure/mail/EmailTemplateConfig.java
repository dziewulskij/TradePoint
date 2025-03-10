package pl.dziewulskij.tradepoint.infrastructure.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.mail.template")
public class EmailTemplateConfig {

    private Map<EmailType, EmailTemplateData> config;

    public Map<EmailType, EmailTemplateData> getTemplates() {
        return config;
    }

    @Data
    public static class EmailTemplateData {

        private String path;
        private String subject;

    }

}
