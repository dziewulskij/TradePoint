package pl.dziewulskij.tradepoint.domain.shared;

import lombok.NonNull;

public record Email(@NonNull String value) {

    public static Email of(@NonNull String value) {
        return new Email(value);
    }

}
