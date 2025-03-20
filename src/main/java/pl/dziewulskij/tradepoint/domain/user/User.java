package pl.dziewulskij.tradepoint.domain.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.NaturalId;
import pl.dziewulskij.tradepoint.domain.audit.TimeAuditable;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.password.PasswordReset;
import pl.dziewulskij.tradepoint.domain.product.Product;
import pl.dziewulskij.tradepoint.domain.shared.BusinessId;

import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = "USERS",
        indexes = {
                @Index(name = "idx_users__email", columnList = "email", unique = true),
                @Index(name = "idx_users__business_id", columnList = "business_id", unique = true)
        }
)
@ToString(onlyExplicitlyIncluded = true)
public class User extends TimeAuditable {

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    @Builder.Default
    @ToString.Include
    BusinessId businessId = new BusinessId();

    @NaturalId
    @Column(name = "email", length = 100, unique = true, nullable = false)
    String email;

    @Column(name = "first_name", length = 100)
    String firstName;

    @Column(name = "last_name", length = 100)
    String lastName;

    @Column(name = "password", length = 100)
    String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    Set<PasswordReset> passwordResets = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Customer> customers = new HashSet<>();

}
