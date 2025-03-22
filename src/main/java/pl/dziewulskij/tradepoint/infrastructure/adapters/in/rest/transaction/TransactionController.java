package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.command.TransactionResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionOverviewResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.GetTransactionResult;
import pl.dziewulskij.tradepoint.application.port.in.transaction.query.TransactionQueryUseCase;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionOverviewResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.GetTransactionResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.mapper.TransactionApiMapper;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.List;
import java.util.UUID;

@InputAdapter
@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionCommandUseCase transactionCommandUseCase;
    private final TransactionQueryUseCase transactionQueryUseCase;
    private final TransactionApiMapper transactionApiMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse create(@RequestBody @Valid TransactionRequest request) {
        TransactionCommand createCommand = transactionApiMapper.toCommand(request);
        TransactionResult transactionResult = transactionCommandUseCase.create(createCommand);
        return transactionApiMapper.toResponse(transactionResult);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponse update(@PathVariable UUID id, @RequestBody @Valid TransactionRequest request) {
        TransactionCommand updateCommand = transactionApiMapper.toCommand(request);
        TransactionResult transactionResult = transactionCommandUseCase.update(BusinessId.of(id), updateCommand);
        return transactionApiMapper.toResponse(transactionResult);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetTransactionResponse getById(@PathVariable UUID id) {
        GetTransactionResult transactionResult = transactionQueryUseCase.getById(BusinessId.of(id));
        return transactionApiMapper.toResponse(transactionResult);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetTransactionOverviewResponse> getAll() {
        List<GetTransactionOverviewResult> transactionResult = transactionQueryUseCase.getAll();
        return transactionApiMapper.toResponseList(transactionResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        transactionCommandUseCase.delete(BusinessId.of(id));
    }
}
