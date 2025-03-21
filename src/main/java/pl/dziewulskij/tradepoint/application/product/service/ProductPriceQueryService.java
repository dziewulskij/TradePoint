package pl.dziewulskij.tradepoint.application.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.product.command.price.ProductPriceResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ActualProductPriceUseCase;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ProductPriceQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.out.product.LoadProductPricePort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductPriceMapper;
import pl.dziewulskij.tradepoint.domain.exception.ProductPriceNotFoundException;
import pl.dziewulskij.tradepoint.domain.product.ProductPrice;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPriceQueryService implements ProductPriceQueryUseCase, ActualProductPriceUseCase {

    private final LoadProductPricePort loadProductPricePort;
    private final ProductPriceMapper productPriceMapper;

    @Override
    public List<ProductPriceResult> getAllByProductId(BusinessId productId) {
        List<ProductPrice> productPrices = loadProductPricePort.findAllByProductId(productId);
        return productPriceMapper.toResultList(productPrices);
    }

    @Override
    public ProductPriceResult getActualProductPrice(BusinessId productId) {
        return loadProductPricePort.findActualProductPrice(productId)
                .map(productPriceMapper::toResult)
                .orElseThrow(ProductPriceNotFoundException::new);
    }
}
