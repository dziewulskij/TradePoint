package pl.dziewulskij.tradepoint.application.port.in.product.query;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

import java.util.List;

@InputPort
public interface ProductQueryUseCase {

    List<GetProductResult> getAll();

}
