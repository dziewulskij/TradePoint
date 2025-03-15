package pl.dziewulskij.tradepoint.application.port.in.product.query;

import java.util.UUID;

public record GetProductResult(UUID id, String name, String unit) {
}
