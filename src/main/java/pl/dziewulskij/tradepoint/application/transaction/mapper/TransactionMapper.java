package pl.dziewulskij.tradepoint.application.transaction.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionOverviewResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionResult;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.info.TransactionOverviewInfo;

import java.util.List;

@Mapper(uses = {TransactionCustomerMapper.class, TransactionProductMapper.class})
public interface TransactionMapper {

    @Mapping(source = "businessId", target = "id")
    @Mapping(source = "customer.businessId", target = "customerId")
    @Mapping(source = "product.businessId", target = "productId")
    @Mapping(source = "product.unit", target = "unit")
    @Mapping(source = "product.name", target = "productName")
    TransactionResult toResult(Transaction transaction);

    @Mapping(source = "businessId", target = "id")
    GetTransactionResult toGetResult(Transaction transaction);

    GetTransactionOverviewResult map(TransactionOverviewInfo transaction);

    List<GetTransactionOverviewResult> map(List<TransactionOverviewInfo> transactions);

}
