package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.CreateProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductPriceRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.ProductPriceResponse;

import java.util.List;
import java.util.UUID;

@Mapper(imports = BusinessId.class)
public interface ProductPriceApiMapper {

    @Mapping(target = "productId", expression = "java(BusinessId.of(productId))")
    CreateProductPriceCommand toCreateCommand(CreateProductPriceRequest request, UUID productId);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "productId.value", target = "productId")
    ProductPriceResponse toResult(ProductPriceResult result);

    List<ProductPriceResponse> toResultList(List<ProductPriceResult> productPrices);

}
