package pl.dziewulskij.tradepoint.application.port.in.transaction.query;

import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.TransactionTotalType;

import java.math.BigDecimal;
import java.util.Map;

public interface TransactionTotalCalculateUseCase {

    Map<TransactionTotalType, BigDecimal> calculate(BusinessId customerId);
}
