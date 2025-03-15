package pl.dziewulskij.tradepoint.application.port.in.product.query;

import java.util.List;

public interface ProductQueryUseCase {

    List<GetProductResult> getAll();

}
