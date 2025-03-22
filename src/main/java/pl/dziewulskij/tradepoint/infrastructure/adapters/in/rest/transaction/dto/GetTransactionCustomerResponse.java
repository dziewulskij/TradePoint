package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

import java.util.UUID;

public record GetTransactionCustomerResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("companyName") String companyName,
        @JsonProperty("taxId") String taxId,
        @JsonProperty("phone") String phone,
        @JsonProperty("customerType") CustomerType customerType
) {
}
