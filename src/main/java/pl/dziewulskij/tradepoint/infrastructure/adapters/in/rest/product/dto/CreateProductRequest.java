package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
        @NotBlank
        @JsonProperty("name")
        String name,

        @JsonProperty("unit")
        String unit
) {
}
