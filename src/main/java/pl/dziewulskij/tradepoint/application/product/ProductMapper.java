package pl.dziewulskij.tradepoint.application.product;

import lombok.experimental.UtilityClass;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.command.UpdateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.user.User;

@UtilityClass
public class ProductMapper {

    static Product toCreate(CreateProductCommand command, User user) {
        return Product.builder()
                .name(command.name())
                .unit(command.unit())
                .user(user)
                .build();
    }

    static CreateProductResult toCreateResult(Product product) {
        return new CreateProductResult(product.getBusinessId().value(), product.getName(), product.getUnit());
    }

    static UpdateProductResult toUpdateResult(Product product) {
        return new UpdateProductResult(product.getBusinessId().value(), product.getName(), product.getUnit());
    }

    static GetProductResult toGetProductResult(Product product) {
        return new GetProductResult(product.getBusinessId().value(), product.getName(), product.getUnit());
    }

}
