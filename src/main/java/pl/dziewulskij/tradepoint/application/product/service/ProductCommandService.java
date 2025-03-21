package pl.dziewulskij.tradepoint.application.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dziewulskij.tradepoint.application.port.in.product.command.*;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductMapper;
import pl.dziewulskij.tradepoint.application.product.validator.ProductBelongToUserValidator;
import pl.dziewulskij.tradepoint.application.product.validator.ProductNameUniquenessValidator;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final SaveProductPort saveProductPort;
    private final ProductProvider productProvider;
    private final UserProvider userProvider;
    private final ProductMapper productMapper;
    private final ProductNameUniquenessValidator productNameUniquenessValidator;
    private final ProductBelongToUserValidator productBelongToUserValidator;

    @Override
    public CreateProductResult create(CreateProductCommand command) {
        productNameUniquenessValidator.validateForCreation(command.name());
        User user = userProvider.currentUser();
        Product product = Product.create(command, user);
        saveProductPort.save(product);
        return productMapper.toCreateResult(product);
    }

    @Override
    @Transactional
    public UpdateProductResult update(UpdateProductCommand command) {
        productBelongToUserValidator.validate(command.businessId());
        Product product = productProvider.byBusinessId(command.businessId());
        productNameUniquenessValidator.validateForUpdate(command.name(), command.businessId());
        product.update(command);
        saveProductPort.save(product);
        return productMapper.toUpdateResult(product);
    }

}
