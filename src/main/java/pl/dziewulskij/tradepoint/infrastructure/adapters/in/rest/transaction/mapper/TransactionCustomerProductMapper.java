package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionCustomerResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionCustomerResponse;

@Mapper
public interface TransactionCustomerProductMapper {

    @Mapping(source = "id.value", target = "id")
    GetTransactionCustomerResponse toResponse(GetTransactionCustomerResult result);
}
