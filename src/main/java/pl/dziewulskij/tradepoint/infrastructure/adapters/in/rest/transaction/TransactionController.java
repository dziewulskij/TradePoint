package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.transaction.CreateTransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

@InputAdapter
@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionCommandUseCase transactionCommandUseCase;
    private final TransactionApiMapper transactionApiMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse create(@RequestBody @Valid TransactionRequest request) {
        CreateTransactionCommand createCommand = transactionApiMapper.toCreateCommand(request);
        TransactionResult transactionResult = transactionCommandUseCase.create(createCommand);
        return transactionApiMapper.toResponse(transactionResult);
    }
}
