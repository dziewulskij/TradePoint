package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.customer.service.CustomerCommandServiceDelegate;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.CustomerQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.CustomerResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.customer.dto.GetCustomerResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.List;
import java.util.UUID;

@InputAdapter
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerCommandServiceDelegate customerCommandUseCase;
    private final CustomerQueryUseCase customerQueryUseCase;
    private final CustomerRestMapper customerRestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        CustomerApiValidator.validate(request);
        CustomerCommand createCommand = customerRestMapper.toCommand(request);
        CommandCustomerResult commandCustomerResult = customerCommandUseCase.create(createCommand);
        return customerRestMapper.toResponse(commandCustomerResult);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable UUID id, @RequestBody @Valid CustomerRequest request) {
        CustomerApiValidator.validate(request);
        CustomerCommand updateCommand = customerRestMapper.toCommand(request);
        CommandCustomerResult updateResult = customerCommandUseCase.update(BusinessId.of(id), updateCommand);
        return customerRestMapper.toResponse(updateResult);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetCustomerResponse> getAll() {
        List<GetCustomerResult> getCustomerResults = customerQueryUseCase.getAll();
        return customerRestMapper.toResponseList(getCustomerResults);
    }


}
