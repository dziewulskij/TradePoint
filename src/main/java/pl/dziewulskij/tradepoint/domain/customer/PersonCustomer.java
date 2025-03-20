package pl.dziewulskij.tradepoint.domain.customer;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;

@Entity
@DiscriminatorValue("PERSON")
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonCustomer extends Customer {

    @Column(name = "first_name", length = 100)
    String firstName;

    @Column(name = "last_name", length = 100)
    String lastName;

    @Column(name = "pesel", length = 11)
    String pesel;

    public void update(CustomerCommand command) {
        super.email = command.email();
        this.phone = command.phone();
        this.bankAccountNo = command.bankAccountNo();
        this.notes = command.notes();
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.pesel = command.pesel();
    }

}
