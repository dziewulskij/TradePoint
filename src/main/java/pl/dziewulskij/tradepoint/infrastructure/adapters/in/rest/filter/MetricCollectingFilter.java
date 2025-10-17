package pl.dziewulskij.tradepoint.infrastructure.adapters.in.rest.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class MetricCollectingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long newCount = HttpRequestMetric.getInstance().incrementRequestCount();
        log.info("Request served. Total count: {}", newCount);
        filterChain.doFilter(request, response);
    }
}
