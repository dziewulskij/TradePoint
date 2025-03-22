package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionProductResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionProductResponse;

@Mapper
public interface TransactionProductApiMapper {

    @Mapping(source = "id.value", target = "id")
    GetTransactionProductResponse toResponse(GetTransactionProductResult result);
}
