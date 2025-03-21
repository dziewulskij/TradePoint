package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ProductPriceResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("productId") UUID productId,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("validFrom") LocalDate validFrom
) {
}
