package pl.dziewulskij.tradepoint.infrastructure.mail;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@UtilityClass
public class EmailTemplateLoader {

    public static String load(String templatePath) {
        try (InputStream inputStream = new ClassPathResource(templatePath).getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new EmailTemplateLoadException(e);
        }
    }

}
