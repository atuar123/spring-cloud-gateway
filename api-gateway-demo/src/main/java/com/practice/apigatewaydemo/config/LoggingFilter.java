package com.practice.apigatewaydemo.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Custom pre filter here
        return (exchange, chain) -> {
            // Log request information
            System.out.println("Request path: " + exchange.getRequest().getPath());

            // Continue to the next filter in the chain
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Custom post filter here
                // Log response information
                System.out.println("Response code: " + exchange.getResponse().getStatusCode());
            }));
        };
    }

    public static class Config {
        // Add configuration properties if needed
    }
}
