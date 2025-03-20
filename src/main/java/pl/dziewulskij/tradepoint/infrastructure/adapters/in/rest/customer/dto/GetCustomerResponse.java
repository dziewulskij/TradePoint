package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;

import java.util.UUID;

public record GetCustomerResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("pesel") String pesel,
        @JsonProperty("email") String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("bankAccountNo") String bankAccountNo,
        @JsonProperty("companyName") String companyName,
        @JsonProperty("companyShortName") String companyShortName,
        @JsonProperty("taxId") String taxId,
        @JsonProperty("notes") String notes,
        @JsonProperty("type") CustomerType type
) {
}
