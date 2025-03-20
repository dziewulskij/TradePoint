package pl.dziewulskij.tradepoint.application.port.in.customer.command;

public record CustomerCommand(
        String email,
        String phone,
        String bankAccountNo,
        String taxId,
        String notes,
        String companyName,
        String companyShortName
) {
}
