package pl.dziewulskij.tradepoint.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.dziewulskij.tradepoint.infrastructure.security.factory.RSAPublicKeyFactory;

import static org.springframework.security.config.Customizer.withDefaults;

@Order(1)
@Profile("secure")
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Value("${app.security.publicKey}")
    private String publicKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(configurer -> configurer
                        .jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtWithKeyDecoder())))
                .logout(configurer -> configurer
                        .logoutUrl("/logout")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtWithKeyDecoder() {
        var rsaPublicKey = RSAPublicKeyFactory.create(publicKey);
        return NimbusJwtDecoder
                .withPublicKey(rsaPublicKey)
                .build();
    }

}
