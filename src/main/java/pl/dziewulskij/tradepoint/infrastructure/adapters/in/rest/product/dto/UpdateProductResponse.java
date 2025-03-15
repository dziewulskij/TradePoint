package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto;

import java.util.UUID;

public record UpdateProductResponse(UUID id, String name, String unit) {
}
