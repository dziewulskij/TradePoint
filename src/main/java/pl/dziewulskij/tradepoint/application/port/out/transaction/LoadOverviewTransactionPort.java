package pl.dziewulskij.tradepoint.application.port.out.transaction;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.info.TransactionOverviewInfo;

import java.util.List;

public interface LoadOverviewTransactionPort {

    List<TransactionOverviewInfo> findAll(BusinessId userId);

}
