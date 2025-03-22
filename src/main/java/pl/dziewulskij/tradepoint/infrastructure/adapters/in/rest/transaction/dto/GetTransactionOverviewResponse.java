package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.domain.transaction.PaymentStatus;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetTransactionOverviewResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("productName") String productName,
        @JsonProperty("productUnit") String productUnit,
        @JsonProperty("customerName") String customerName,
        @JsonProperty("customerType") CustomerType customerType,
        @JsonProperty("transactionType") TransactionType transactionType,
        @JsonProperty("paymentStatus") PaymentStatus paymentStatus,
        @JsonProperty("quantity") BigDecimal quantity,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("total") BigDecimal total,
        @JsonProperty("transactionDate") LocalDateTime transactionDate
) {
}
