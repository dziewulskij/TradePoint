package pl.dziewulskij.tradepoint.application.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.CreateProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPricePort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductPriceMapper;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;

@Service
@RequiredArgsConstructor
public class ProductPriceCommandService implements ProductPriceCommandUseCase {

    private final SaveProductPricePort saveProductPricePort;
    private final ProductProvider productProvider;
    private final ProductPriceMapper productPriceMapper;

    @Override
    public ProductPriceResult create(CreateProductPriceCommand command) {
        Product product = productProvider.byBusinessId(command.productId());
        ProductPrice productPrice = ProductPrice.create(command, product);
        saveProductPricePort.save(productPrice);
        return productPriceMapper.toResult(productPrice);
    }
}
