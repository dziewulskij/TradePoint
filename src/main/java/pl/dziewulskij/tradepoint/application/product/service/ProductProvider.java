package pl.dziewulskij.tradepoint.application.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.product.LoadProductPort;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

@Component
@RequiredArgsConstructor
public class ProductProvider {

    private final LoadProductPort loadProductPort;

    public Product byBusinessId(BusinessId businessId) {
        return loadProductPort.findByBusinessId(businessId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
