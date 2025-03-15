package pl.dziewulskij.tradepoint.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dziewulskij.tradepoint.application.port.in.product.command.*;
import pl.dziewulskij.tradepoint.application.port.out.product.SaveProductPort;
import pl.dziewulskij.tradepoint.application.user.UserProvider;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.domain.user.User;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final SaveProductPort saveProductPort;
    private final ProductProvider productProvider;
    private final UserProvider userProvider;
    private final ProductNameUniquenessValidator productNameUniquenessValidator;

    @Override
    public CreateProductResult create(CreateProductCommand command) {
        productNameUniquenessValidator.validateForCreation(command.name());
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userProvider.byBusinessId(BusinessId.fromString(userId));
        Product product = ProductMapper.toCreate(command, user);
        saveProductPort.save(product);
        return ProductMapper.toCreateResult(product);
    }

    @Override
    @Transactional
    public UpdateProductResult update(UpdateProductCommand command) {
        Product product = productProvider.byBusinessId(command.businessId());
        productNameUniquenessValidator.validateForUpdate(command.name(), command.businessId());
        product.setName(command.name());
        product.setUnit(command.unit());
        saveProductPort.save(product);
        return ProductMapper.toUpdateResult(product);
    }

}
