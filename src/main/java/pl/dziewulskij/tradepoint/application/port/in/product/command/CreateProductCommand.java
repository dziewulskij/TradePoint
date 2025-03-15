package pl.dziewulskij.tradepoint.application.port.in.product.command;

import lombok.NonNull;

public record CreateProductCommand(@NonNull String name, String unit) {
}
