package pl.dziewulskij.tradepoint.application.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionOverviewResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.TransactionQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.out.transaction.LoadOverviewTransactionPort;
import pl.dziewulskij.tradepoint.application.transaction.mapper.TransactionMapper;
import pl.dziewulskij.tradepoint.application.transaction.validator.TransactionBelongToUserValidator;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.transaction.Transaction;
import pl.dziewulskij.tradepoint.domain.transaction.info.PaidTransactionOverviewCollection;
import pl.dziewulskij.tradepoint.domain.transaction.info.TransactionOverviewInfo;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionQueryService implements TransactionQueryUseCase {

    private final TransactionProvider transactionProvider;
    private final TransactionMapper transactionMapper;
    private final LoadOverviewTransactionPort loadOverviewTransactionPort;
    private final TransactionBelongToUserValidator transactionBelongToUserValidator;

    @Override
    public GetTransactionResult getById(BusinessId transactionId) {
        transactionBelongToUserValidator.validate(transactionId);
        Transaction transaction = transactionProvider.byBusinessIdFetchProductAndCustomer(transactionId);
        return transactionMapper.toGetResult(transaction);
    }

    @Override
    public List<GetTransactionOverviewResult> getAll() {
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();
        List<TransactionOverviewInfo> transactions = loadOverviewTransactionPort.findAll(currentUserId);
        return transactionMapper.map(transactions);
    }

    @Override
    public BigDecimal getSumPaidTransactions() {
        BigDecimal sum = BigDecimal.ZERO;
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();
        List<TransactionOverviewInfo> transactions = loadOverviewTransactionPort.findAll(currentUserId);
        for (TransactionOverviewInfo tx : new PaidTransactionOverviewCollection(transactions)) {
            sum = sum.add(tx.getTotal().total());
        }
        return sum;
    }

}
