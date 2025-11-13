package pl.dziewulskij.tradepoint.domain.customer;

public interface CustomerVisitor<R> {

    R visit(Customer customer);
}
