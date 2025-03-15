package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.command.UpdateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.UpdateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.*;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class ProductRestMapper {

    static CreateProductResponse toResponse(CreateProductResult result) {
        return new CreateProductResponse(result.id(), result.name(), result.unit());
    }

    static List<GetProductResponse> toResponseList(List<GetProductResult> result) {
        return result.stream()
                .map(ProductRestMapper::toResponse)
                .toList();
    }

    static GetProductResponse toResponse(GetProductResult result) {
        return new GetProductResponse(result.id(), result.name(), result.unit());
    }

    static CreateProductCommand toCreateCommand(CreateProductRequest request) {
        String unit = request.unit();
        return new CreateProductCommand(
                request.name().trim(),
                StringUtils.isBlank(unit) ? null : unit.trim()
        );
    }

    public static UpdateProductCommand toUpdateCommand(UUID id, UpdateProductRequest request) {
        return new UpdateProductCommand(id, request.name(), request.unit());
    }

    public static UpdateProductResponse toResponse(UpdateProductResult result) {
        return new UpdateProductResponse(result.id(), result.name(), result.unit());
    }
}
