package pl.dziewulskij.tradepoint.infrastructure.adapters.out.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dziewulskij.tradepoint.domain.user.User;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}
