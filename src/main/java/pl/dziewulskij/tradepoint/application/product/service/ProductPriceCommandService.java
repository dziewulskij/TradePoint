package pl.dziewulskij.tradepoint.application.product.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.CreateProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.DeleteProductPriceCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.application.port.out.product.DeleteProductPricePort;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPricePort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductPriceMapper;
import pl.dziewulskij.tradepoint.application.product.validator.ProductPriceBelongToUserValidator;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.product.ProductPriceWithProductIds;

@Service
@RequiredArgsConstructor
public class ProductPriceCommandService implements ProductPriceCommandUseCase {

    private final SaveProductPricePort saveProductPricePort;
    private final DeleteProductPricePort deleteProductPricePort;
    private final ProductProvider productProvider;
    private final ProductPriceMapper productPriceMapper;
    private final ProductPriceBelongToUserValidator productPriceBelongToUserValidator;

    @Override
    @Transactional
    public ProductPriceResult create(CreateProductPriceCommand command) {
        Product product = productProvider.byBusinessId(command.productId());
        ProductPrice productPrice = ProductPrice.create(command, product);
        saveProductPricePort.save(productPrice);
        return productPriceMapper.toResult(productPrice);
    }

    @Override
    @Transactional
    public void delete(DeleteProductPriceCommand command) {
        ProductPriceWithProductIds productPriceWithProductIds = command.productPriceWithProductIds();
        productPriceBelongToUserValidator.validate(productPriceWithProductIds);
        deleteProductPricePort.deleteById(productPriceWithProductIds.productPriceId());
    }
}
