package pl.dziewulskij.tradepoint.application.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.product.query.GetProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.query.ProductQueryUseCase;
import pl.dziewulskij.tradepoint.application.port.out.product.LoadProductPort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductMapper;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

    private final LoadProductPort loadProductPort;
    private final ProductMapper productMapper;

    @Override
    public List<GetProductResult> getAll() {
        BusinessId currentUserId = AuthenticationUtils.getCurrentUserId();

        return loadProductPort.findAllByUserId(currentUserId).stream()
                .map(productMapper::toGetProductResult)
                .toList();
    }

}
