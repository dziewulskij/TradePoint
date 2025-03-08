package pl.dziewulskij.tradepoint.infrastructure.security.provider;

import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.infrastructure.security.factory.RSAPrivateKeyFactory;
import pl.dziewulskij.tradepoint.infrastructure.security.model.JwtCreationDetails;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtTokenProvider {

    private static final String ISSUER = "TradePoint";
    private static final String ID_CLAIM = "id";
    private static final String EMAIL_CLAIM = "email";
    private static final String FIRST_NAME_CLAIM = "firstName";
    private static final String LAST_NAME_CLAIM = "lastName";

    @Value("${app.security.privateKey:}")
    private String privateKey;

    @Value("${app.jwt.validity-in-ms:3600000}")
    private long validityInMilliseconds;

    public String generateToken(@NonNull JwtCreationDetails jwtCreationDetails) {
        var rsaPrivateKey = RSAPrivateKeyFactory.create(privateKey);

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(ISSUER)
                .subject(jwtCreationDetails.id().stringValue())
                .claims(buildClaims(jwtCreationDetails))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(rsaPrivateKey)
                .compact();
    }

    private static Map<String, String> buildClaims(JwtCreationDetails jwtCreationDetails) {
        return Map.of(
                ID_CLAIM, jwtCreationDetails.id().stringValue(),
                EMAIL_CLAIM, jwtCreationDetails.email(),
                FIRST_NAME_CLAIM, jwtCreationDetails.firstName(),
                LAST_NAME_CLAIM, jwtCreationDetails.lastName()
        );
    }

}
