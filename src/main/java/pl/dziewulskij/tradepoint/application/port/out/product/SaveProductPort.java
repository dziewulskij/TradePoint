package pl.dziewulskij.tradepoint.application.port.out.product;

import pl.dziewulskij.tradepoint.domain.product.Product;

public interface SaveProductPort {

    Product save(Product product);

}
