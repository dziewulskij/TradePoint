package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.CreateTransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Price;
import pl.dziewulskij.tradepoint.domain.shared.Quantity;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionResponse;

@Mapper(imports = {Quantity.class, Price.class, BusinessId.class})
public interface TransactionApiMapper {

    @Mapping(target = "quantity", expression = "java(Quantity.of(request.quantity()))")
    @Mapping(target = "price", expression = "java(Price.of(request.price()))")
    @Mapping(target = "customerId", expression = "java(BusinessId.of(request.customerId()))")
    @Mapping(target = "productId", expression = "java(BusinessId.of(request.productId()))")
    CreateTransactionCommand toCreateCommand(TransactionRequest request);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "customerId.value", target = "customerId")
    @Mapping(source = "productId.value", target = "productId")
    @Mapping(source = "total.quantity.value", target = "quantity")
    @Mapping(source = "total.price.value", target = "price")
    @Mapping(target = "total", expression = "java(result.total().total())")
    TransactionResponse toResponse(TransactionResult result);

}
