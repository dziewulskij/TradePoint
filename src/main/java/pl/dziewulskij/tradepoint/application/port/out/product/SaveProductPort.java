package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.infrastructure.annotations.OutputPort;

@OutputPort
public interface SaveProductPort {

    Product save(Product product);

}
