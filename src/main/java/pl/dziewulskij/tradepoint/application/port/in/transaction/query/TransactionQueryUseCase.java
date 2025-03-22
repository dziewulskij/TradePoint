package pl.dziewulskij.tradepoint.application.port.in.transaction.query;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;

public interface TransactionQueryUseCase {

    GetTransactionResult getById(BusinessId transactionId);

    List<GetTransactionOverviewResult> getAll();

}
