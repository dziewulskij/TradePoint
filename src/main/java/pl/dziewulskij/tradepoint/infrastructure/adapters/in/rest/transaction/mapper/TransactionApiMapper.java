package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionOverviewResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.shared.Price;
import pl.dziewulskij.tradepoint.domain.shared.Quantity;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionOverviewResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionResponse;

import java.util.List;

@Mapper(
        uses = {TransactionProductApiMapper.class, TransactionCustomerProductMapper.class},
        imports = {Quantity.class, Price.class, BusinessId.class}
)
public interface TransactionApiMapper {

    @Mapping(target = "quantity", expression = "java(Quantity.of(request.quantity()))")
    @Mapping(target = "price", expression = "java(Price.of(request.price()))")
    @Mapping(target = "customerId", expression = "java(BusinessId.of(request.customerId()))")
    @Mapping(target = "productId", expression = "java(BusinessId.of(request.productId()))")
    TransactionCommand toCommand(TransactionRequest request);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "customerId.value", target = "customerId")
    @Mapping(source = "productId.value", target = "productId")
    @Mapping(source = "total.quantity.value", target = "quantity")
    @Mapping(source = "total.price.value", target = "price")
    @Mapping(target = "total", expression = "java(result.total().total())")
    TransactionResponse toResponse(TransactionResult result);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "total.quantity.value", target = "quantity")
    @Mapping(source = "total.price.value", target = "price")
    @Mapping(target = "total", expression = "java(result.total().total())")
    GetTransactionResponse toResponse(GetTransactionResult result);

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "total.quantity.value", target = "quantity")
    @Mapping(source = "total.price.value", target = "price")
    @Mapping(target = "total", expression = "java(result.total().total())")
    GetTransactionOverviewResponse toResponse(GetTransactionOverviewResult result);

    List<GetTransactionOverviewResponse> toResponseList(List<GetTransactionOverviewResult> transactionResult);
}
