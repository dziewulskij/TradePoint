package pl.dziewulskij.tradepoint.infrastructure.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("secure")
@Data
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "app.security.cors")
public class CorsConfigProperties {

    Allowed allowed;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Allowed {
        List<String> origins;
        List<String> headers;
        List<String> methods;
    }
}
