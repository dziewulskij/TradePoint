package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record GetTransactionProductResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("name") String name,
        @JsonProperty("unit") String unit
) {
}
