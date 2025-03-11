package pl.dziewulskij.tradepoint.application.port.in.auth;

import lombok.NonNull;

public record UserLoginResult(@NonNull String token) {
}
