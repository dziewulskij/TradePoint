package pl.dziewulskij.tradepoint.application.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.command.UpdateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Mapper(imports = BusinessId.class)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "businessId", expression = "java(new BusinessId())")
    @Mapping(source = "command.name", target = "name")
    @Mapping(source = "command.unit", target = "unit")
    @Mapping(source = "user", target = "user")
    Product toCreate(CreateProductCommand command, User user);

    @Mapping(source = "businessId.value", target = "id")
    CreateProductResult toCreateResult(Product product);

    @Mapping(source = "businessId.value", target = "id")
    UpdateProductResult toUpdateResult(Product product);

    @Mapping(source = "businessId.value", target = "id")
    GetProductResult toGetProductResult(Product product);

}
