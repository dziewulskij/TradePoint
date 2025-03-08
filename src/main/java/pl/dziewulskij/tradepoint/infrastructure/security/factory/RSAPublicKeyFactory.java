package pl.dziewulskij.tradepoint.infrastructure.security.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RSAPublicKeyFactory {

    private static final String BEGIN_FILE = "-----BEGIN PUBLIC KEY-----";
    private static final String END_FILE = "-----END PUBLIC KEY-----";
    private static final String EMPTY_STRING = "";
    private static final String RSA_ALGORITHM_NAME = "RSA";

    @SneakyThrows
    public static RSAPublicKey create(@NonNull String publicKey) {
        var encoded = decodeKey(publicKey);
        var keySpec = new X509EncodedKeySpec(encoded);
        var keyFactory = KeyFactory.getInstance(RSA_ALGORITHM_NAME);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    private static byte[] decodeKey(String key) {
        var strippedKey = key.replace(BEGIN_FILE, EMPTY_STRING)
                .replace(END_FILE, EMPTY_STRING)
                .replaceAll("\\s", EMPTY_STRING);

        return Base64.getDecoder().decode(strippedKey);
    }

}
