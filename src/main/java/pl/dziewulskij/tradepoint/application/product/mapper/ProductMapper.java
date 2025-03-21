package pl.dziewulskij.tradepoint.application.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Mapper(imports = BusinessId.class)
public interface ProductMapper {

    @Mapping(source = "businessId.value", target = "id")
    CreateProductResult toCreateResult(Product product);

    @Mapping(source = "businessId.value", target = "id")
    GetProductResult toGetProductResult(Product product);

}
