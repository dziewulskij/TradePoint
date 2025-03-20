package pl.dziewulskij.tradepoint.domain.customer;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;

@Entity
@DiscriminatorValue("COMPANY")
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyCustomer extends Customer {

    @Column(name = "company_name")
    String companyName;

    @Column(name = "company_short_name", length = 100)
    String companyShortName;

    @Column(name = "tax_id", length = 10)
    String taxId;

    public void update(CustomerCommand command) {
        super.email = command.email();
        this.phone = command.phone();
        this.bankAccountNo = command.bankAccountNo();
        this.notes = command.notes();
        this.companyName = command.companyName();
        this.companyShortName = command.companyShortName();
        this.taxId = command.taxId();
    }
}
