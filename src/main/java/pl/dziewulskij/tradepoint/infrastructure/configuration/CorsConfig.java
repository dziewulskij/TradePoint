package pl.dziewulskij.tradepoint.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Profile("secure")
@Configuration
@RequiredArgsConstructor
public class CorsConfig {

    private final CorsConfigProperties corsConfigProperties;

    @Bean
    public CorsFilter corsFilter() {
        var source = new UrlBasedCorsConfigurationSource();
        var config = new CorsConfiguration();
        var corsAllowed = corsConfigProperties.getAllowed();

        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(corsAllowed.getOrigins());
        config.setAllowedHeaders(corsAllowed.getHeaders());
        config.setAllowedMethods(corsAllowed.getMethods());
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
