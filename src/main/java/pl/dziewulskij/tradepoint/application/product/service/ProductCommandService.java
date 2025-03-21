package pl.dziewulskij.tradepoint.application.product.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductCommand;
import pl.dziewulskij.tradepoint.application.port.in.product.command.CreateProductResult;
import pl.dziewulskij.tradepoint.application.port.in.product.command.ProductCommandUseCase;
import pl.dziewulskij.tradepoint.application.port.out.product.DeleteProductPort;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPort;
import pl.dziewulskij.tradepoint.application.product.mapper.ProductMapper;
import pl.dziewulskij.tradepoint.application.product.validator.ProductCommandValidatorFacade;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final SaveProductPort saveProductPort;
    private final DeleteProductPort deleteProductPort;
    private final UserProvider userProvider;
    private final ProductMapper productMapper;
    private final ProductCommandValidatorFacade productCommandValidatorFacade;

    @Override
    @Transactional
    public CreateProductResult create(CreateProductCommand command) {
        productCommandValidatorFacade.validateForCreation(command.name());
        User user = userProvider.currentUser();
        Product product = Product.create(command, user);
        saveProductPort.save(product);
        return productMapper.toCreateResult(product);
    }

    @Override
    @Transactional
    public void delete(BusinessId productId) {
        productCommandValidatorFacade.validateForDeletion(productId);
        deleteProductPort.deleteByBusinessId(productId);
    }

}
