package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.filter;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public final class HttpRequestMetric {

    private static volatile HttpRequestMetric INSTANCE;

    public HttpRequestMetric() {
        // Private constructor for Singleton
    }

    public static HttpRequestMetric getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (HttpRequestMetric.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new HttpRequestMetric();
                }
            }
        }
        return INSTANCE;
    }

    private final AtomicLong requestCount = new AtomicLong(0);

    public long incrementRequestCount() {
        return requestCount.incrementAndGet();
    }

    public long getCurrentCount() {
        return requestCount.get();
    }
}
