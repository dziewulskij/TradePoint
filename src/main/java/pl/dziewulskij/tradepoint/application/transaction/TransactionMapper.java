package pl.dziewulskij.tradepoint.application.transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;

@Mapper
public interface TransactionMapper {

    @Mapping(source = "businessId", target = "id")
    @Mapping(source = "customer.businessId", target = "customerId")
    @Mapping(source = "product.businessId", target = "productId")
    @Mapping(source = "product.unit", target = "unit")
    @Mapping(source = "product.name", target = "productName")
    TransactionResult toResult(Transaction transaction);

}
