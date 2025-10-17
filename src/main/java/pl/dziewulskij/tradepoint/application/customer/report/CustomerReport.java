package pl.dziewulskij.tradepoint.application.customer.report;

import pl.dziewulskij.tradepoint.domain.customer.CompanyCustomer;
import pl.dziewulskij.tradepoint.domain.customer.Customer;
import pl.dziewulskij.tradepoint.domain.customer.PersonCustomer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerReport implements ReportPrototype<CustomerReport> {

    private final String title;
    private final String header;
    private final String footer;
    private String content;
    private LocalDateTime generationDate;

    public CustomerReport(String title, String header, String footer) {
        this.title = title;
        this.header = header;
        this.footer = footer;
    }

    public CustomerReport(CustomerReport source) {
        this.title = source.title;
        this.header = source.header;
        this.footer = source.footer;
    }

    @Override
    public CustomerReport copy() {
        return new CustomerReport(this);
    }

    @Override
    public void print() {
        if (content == null || generationDate == null) {
            throw new IllegalStateException("The report has not been filled with data.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String reportContent = String.join("\n",
                "==================================================",
                "## " + title + " ##",
                "--------------------------------------------------",
                header,
                "--------------------------------------------------",
                content,
                "--------------------------------------------------",
                footer,
                "Generated: " + generationDate.format(formatter),
                "=================================================="
        );

        System.out.println("\n" + reportContent);
    }

    public void fillWithData(Customer customer) {
        this.generationDate = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(customer.getBusinessId().getValue()).append("\n");
        sb.append("Email: ").append(customer.getEmail()).append("\n");

        if (customer instanceof PersonCustomer person) {
            sb.append("Type: Individual\n");
            sb.append("First name and surname: ").append(person.getFirstName()).append(" ").append(person.getLastName()).append("\n");
        } else if (customer instanceof CompanyCustomer company) {
            sb.append("Type: Company\n");
            sb.append("Company name: ").append(company.getCompanyName()).append("\n");
            sb.append("Tax Identification Number: ").append(company.getTaxId()).append("\n");
        }
        this.content = sb.toString();
    }
}
