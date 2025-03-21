package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.CreateProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.DeleteProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ActualProductPriceUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ProductPriceQueryUseCase;
import pl.dziewulskij.tradepoint.domain.product.ProductPriceWithProductIds;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.CreateProductPriceRequest;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.product.dto.ProductPriceResponse;
import pl.dziewulskij.tradepoint.infrastructure.annotations.InputAdapter;

import java.util.List;
import java.util.UUID;

@InputAdapter
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductPriceController {

    private final ProductPriceCommandUseCase productPriceCommandUseCase;
    private final ProductPriceQueryUseCase productPriceQueryUseCase;
    private final ActualProductPriceUseCase actualProductPriceUseCase;
    private final ProductPriceApiMapper productPriceApiMapper;


    @PostMapping("/{productId}/prices")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductPriceResponse create(@PathVariable UUID productId,
                                       @RequestBody @Valid CreateProductPriceRequest request) {
        CreateProductPriceCommand createCommand = productPriceApiMapper.toCreateCommand(request, productId);
        ProductPriceResult productPriceResult = productPriceCommandUseCase.create(createCommand);
        return productPriceApiMapper.toResult(productPriceResult);
    }

    @GetMapping("/{productId}/prices")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductPriceResponse> getAll(@PathVariable UUID productId) {
        List<ProductPriceResult> productPricesResult = productPriceQueryUseCase.getAllByProductId(BusinessId.of(productId));
        return productPriceApiMapper.toResultList(productPricesResult);
    }

    @GetMapping("/{productId}/prices/actual")
    @ResponseStatus(HttpStatus.OK)
    public ProductPriceResponse getActual(@PathVariable UUID productId) {
        ProductPriceResult productPriceResult = actualProductPriceUseCase.getActualProductPrice(BusinessId.of(productId));
        return productPriceApiMapper.toResult(productPriceResult);
    }

    @DeleteMapping("/{productId}/prices/{priceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID productId, @PathVariable UUID priceId) {
        DeleteProductPriceCommand command = new DeleteProductPriceCommand(
                ProductPriceWithProductIds.of(productId, priceId)
        );
        productPriceCommandUseCase.delete(command);
    }

}
