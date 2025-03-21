package pl.dziewulskij.tradepoint.application.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;

@Mapper(imports = BusinessId.class)
public interface ProductPriceMapper {

    @Mapping(source = "businessId", target = "id")
    @Mapping(source = "product.businessId", target = "productId")
    ProductPriceResult toResult(ProductPrice productPrice);

    List<ProductPriceResult> toResultList(List<ProductPrice> productPrices);
}
