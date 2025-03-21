package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(
        @JsonProperty("paymentType") PaymentType paymentType,
        @JsonProperty("paymentStatus") @NotNull PaymentStatus paymentStatus,
        @JsonProperty("quantity") BigDecimal quantity,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("customerId") @NotNull UUID customerId,
        @JsonProperty("productId") @NotNull UUID productId
) {
}
