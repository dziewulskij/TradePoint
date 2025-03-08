package pl.dziewulskij.tradepoint.application.auth.port.in;

import lombok.NonNull;

public record UserLoginResult(@NonNull String token) {
}
