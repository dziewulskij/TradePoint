package pl.dziewulskij.tradepoint.application.port.in.product.command;

public interface ProductCommandUseCase {

    CreateProductResult create(CreateProductCommand command);

    UpdateProductResult update(UpdateProductCommand command);

}
