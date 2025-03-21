package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentType;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("productName") String productName,
        @JsonProperty("unit") String unit,
        @JsonProperty("transactionType") TransactionType transactionType,
        @JsonProperty("paymentType") PaymentType paymentType,
        @JsonProperty("paymentStatus") PaymentStatus paymentStatus,
        @JsonProperty("quantity") BigDecimal quantity,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("total") BigDecimal total,
        @JsonProperty("customerId") UUID customerId,
        @JsonProperty("productId") UUID productId
) {
}
