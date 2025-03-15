package pl.dziewulskij.tradepoint.application.port.in.product.command;

import java.util.UUID;

public record CreateProductResult(UUID id, String name, String unit) {
}
