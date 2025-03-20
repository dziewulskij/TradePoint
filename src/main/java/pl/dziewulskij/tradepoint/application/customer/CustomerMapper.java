package pl.dziewulskij.tradepoint.application.customer;

import lombok.experimental.UtilityClass;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CommandCustomerResult;
import pl.dziewulskij.tradepoint.application.port.in.customer.command.CustomerCommand;
import pl.dziewulskij.tradepoint.application.port.in.customer.query.GetCustomerResult;
import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.user.User;

import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class CustomerMapper {

    static CompanyCustomer toCreate(CustomerCommand command, User user) {
        return CompanyCustomer.builder()
                .companyName(command.companyName())
                .companyShortName(command.companyShortName())
                .taxId(command.taxId())
                .email(command.email())
                .phone(command.phone())
                .bankAccountNo(command.bankAccountNo())
                .notes(command.notes())
                .user(user)
                .build();
    }

    static CommandCustomerResult toResult(CompanyCustomer customer) {
        return new CommandCustomerResult(
                customer.getBusinessId().value(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getBankAccountNo(),
                customer.getTaxId(),
                customer.getNotes(),
                customer.getCompanyName(),
                customer.getCompanyShortName()
        );
    }

    static List<GetCustomerResult> toResultList(List<CompanyCustomer> customers) {
        return Stream.ofNullable(customers)
                .flatMap(List::stream)
                .map(CustomerMapper::toResultGet)
                .toList();
    }

    static GetCustomerResult toResultGet(CompanyCustomer customer) {
        return new GetCustomerResult(
                customer.getBusinessId().value(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getBankAccountNo(),
                customer.getTaxId(),
                customer.getNotes(),
                customer.getCompanyName(),
                customer.getCompanyShortName()
        );
    }
}
