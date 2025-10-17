package pl.dziewulskij.tradepoint.application.customer.report;

public interface ReportPrototype<T> {

    T copy();

    void print();

}
