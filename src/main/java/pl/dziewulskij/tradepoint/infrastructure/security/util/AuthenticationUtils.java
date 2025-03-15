package pl.dziewulskij.tradepoint.infrastructure.security.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.security.Principal;
import java.util.Optional;

@UtilityClass
public class AuthenticationUtils {

    public static BusinessId getCurrentUserId() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Principal::getName)
                .map(BusinessId::fromString)
                .orElseThrow();
    }

}
