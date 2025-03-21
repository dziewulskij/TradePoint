package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.command.ProductCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ProductQueryUseCase;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductResponse;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.GetProductResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.List;
import java.util.UUID;

@InputAdapter
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCommandUseCase productCommandUseCase;
    private final ProductQueryUseCase productQueryUseCase;
    private final ProductApiMapper productApiMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        CreateProductCommand createCommand = productApiMapper.toCreateCommand(request);
        CreateProductResult createProductResult = productCommandUseCase.create(createCommand);
        return productApiMapper.toResponse(createProductResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        productCommandUseCase.delete(BusinessId.of(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAll() {
        List<GetProductResult> getProductResult = productQueryUseCase.getAll();
        return productApiMapper.toResponseList(getProductResult);
    }

}
