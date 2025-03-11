package pl.dziewulskij.tradepoint.infrastructure.adapters.out.mail;

import lombok.experimental.UtilityClass;
import org.apache.commons.text.StringSubstitutor;

import java.util.Map;
import java.util.Objects;

@UtilityClass
public class MailTemplateParamReplacer {

    private static final String PREFIX = "{{";
    private static final String SUFFIX = "}}";

    public static String replace(String template, Map<String, String> params) {
        if (Objects.isNull(params) || params.isEmpty()) {
            return template;
        }
        return new StringSubstitutor(params, PREFIX, SUFFIX).replace(template);
    }

}
