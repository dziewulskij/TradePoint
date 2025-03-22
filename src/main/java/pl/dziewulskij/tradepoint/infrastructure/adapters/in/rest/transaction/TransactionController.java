package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommand;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.transaction.TransactionResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.transaction.dto.TransactionResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.UUID;

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
}
