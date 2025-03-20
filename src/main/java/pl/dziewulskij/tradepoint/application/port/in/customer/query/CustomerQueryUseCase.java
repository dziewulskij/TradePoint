package pl.dziewulskij.tradepoint.application.port.in.customer.query;

import java.util.List;

public interface CustomerQueryUseCase {

    List<GetCustomerResult> getAll();

}
