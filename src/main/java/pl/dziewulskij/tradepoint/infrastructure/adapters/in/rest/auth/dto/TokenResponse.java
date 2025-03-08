package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(@JsonProperty("token") String value) {
}
