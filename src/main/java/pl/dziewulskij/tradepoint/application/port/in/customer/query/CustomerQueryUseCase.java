package pl.dziewulskij.tradepoint.application.port.in.customer.query;

import pl.dziewulskij.tradepoint.infrastructure.annotations.InputPort;

import java.util.List;

@InputPort
public interface CustomerQueryUseCase {

    List<GetCustomerResult> getAll();

}
