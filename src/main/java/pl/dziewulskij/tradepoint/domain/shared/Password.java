package pl.dziewulskij.tradepoint.domain.shared;

import lombok.NonNull;

public record Password(@NonNull String hashedValue) {

}
