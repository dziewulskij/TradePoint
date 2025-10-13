package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GetProductResponse(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("name")
        String name,

        @JsonProperty("unit")
        String unit,

        @JsonProperty("newestPrice")
        BigDecimal newestPrice,

        @JsonProperty("priceSetOnDay")
        LocalDate priceSetOnDay
) {
}
