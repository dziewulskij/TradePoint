package pl.dziewulskij.tradepoint.infrastructure.security.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RSAPrivateKeyFactory {

    private static final String BEGIN_FILE = "-----BEGIN PRIVATE KEY-----";
    private static final String END_FILE = "-----END PRIVATE KEY-----";
    private static final String EMPTY_STRING = "";
    private static final String RSA_ALGORITHM_NAME = "RSA";

    @SneakyThrows
    public static RSAPrivateKey create(String privateKey) {
        var encoded = decodeKey(privateKey);
        var keySpec = new PKCS8EncodedKeySpec(encoded);
        var keyFactory = KeyFactory.getInstance(RSA_ALGORITHM_NAME);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    private static byte[] decodeKey(String key) {
        var strippedKey = key.replace(BEGIN_FILE, EMPTY_STRING)
                .replace(END_FILE, EMPTY_STRING)
                .replaceAll("\\s", EMPTY_STRING);

        return Base64.getDecoder().decode(strippedKey);
    }

}
