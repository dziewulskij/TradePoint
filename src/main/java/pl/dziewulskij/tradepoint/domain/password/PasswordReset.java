package pl.dziewulskij.tradepoint.domain.password;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.dziewulskij.tradepoint.domain.audit.CreatedAtAuditable;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "PASSWORD_RESET")
public class PasswordReset extends CreatedAtAuditable {

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "token", length = 100, unique = true, nullable = false)
    UUID token;

    @Column(name = "expires_at", nullable = false)
    LocalDateTime expiresAt;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}
