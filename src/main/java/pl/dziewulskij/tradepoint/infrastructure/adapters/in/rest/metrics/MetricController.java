package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.metrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.filter.HttpRequestMetric;

@RestController
@RequestMapping("/metrics")
public class MetricController {

    @GetMapping(value = "/requests")
    public String getRequestMetrics() {
        long count = HttpRequestMetric.getInstance().getCurrentCount();
        return "Total requests served: " + count;
    }

}
