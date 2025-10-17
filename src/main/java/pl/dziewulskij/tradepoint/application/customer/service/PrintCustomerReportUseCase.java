package pl.dziewulskij.tradepoint.application.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dziewulskij.tradepoint.application.customer.report.CustomerReport;
import pl.dziewulskij.tradepoint.application.port.out.customer.UserCustomersQueryPort;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.customer.CustomerType;
import pl.dziewulskij.tradepoint.infrastructure.security.util.AuthenticationUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrintCustomerReportUseCase {

    private final UserCustomersQueryPort userCustomersQueryPort;

    public void report() {
        List<Customer> customers = userCustomersQueryPort.getAllByUserId(AuthenticationUtils.getCurrentUserId());
        CustomerReport personCustomerReport = new CustomerReport("Single Person Report", "Person Report", "End of Person Report");
        CustomerReport companyCustomerReport = new CustomerReport("Single Company Report", "Company Report", "End of Company Report");

        extracted(customers, CustomerType.PERSON, personCustomerReport);
        extracted(customers, CustomerType.COMPANY, companyCustomerReport);
    }

    private static void extracted(List<Customer> customers, CustomerType customerType, CustomerReport customerReport) {
        customers.stream()
                .filter(customer -> customer.getCustomerType() == customerType)
                .forEach(customer -> {
                    CustomerReport copy = customerReport.copy();
                    copy.fillWithData(customer);
                    copy.print();
                });
    }

}