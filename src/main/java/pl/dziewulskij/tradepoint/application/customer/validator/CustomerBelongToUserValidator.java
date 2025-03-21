package pl.dziewulskij.tradepoint.application.customer.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dziewulskij.tradepoint.application.port.out.customer.CustomerExistencePort;
import pl.dziewulskij.tradepoint.domain.exception.CustomerNotFoundException;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

@Component
@RequiredArgsConstructor
public class CustomerBelongToUserValidator {

    private final CustomerExistencePort customerExistencePort;

    public void validate(BusinessId customerId) {
        boolean exists = customerExistencePort.existsByIdAndUserId(customerId, AuthenticationUtils.getCurrentUserId());

        if (!exists) {
            throw new CustomerNotFoundException();
        }
    }

}
