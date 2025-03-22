package pl.dziewulskij.tradepoint.application.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionProductResult;
import pl.dziewulskij.tradepoint.domain.product.Product;

@Mapper
public interface TransactionProductMapper {

    @Mapping(source = "businessId", target = "id")
    GetTransactionProductResult map(Product product);

}
