package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateProductPriceRequest(
        @JsonProperty("price")
        @NotNull
        @DecimalMin("0.00")
        @DecimalMax("999999999999999.99")
        BigDecimal price,

        @JsonProperty("validFrom")
        @NotNull
        LocalDate validFrom
) {
}
