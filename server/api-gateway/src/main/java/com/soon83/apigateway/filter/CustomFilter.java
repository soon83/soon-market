package com.soon83.apigateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // 커스텀 PRE 필터에서는 JWT를 추출하거나 인증을 수행할 수 있다.
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("### Custom PRE Filter: request uri -> {}", request.getId());

            // 커스텀 POST 필터에서는 에러코드를 기반으로 에러에 대한 응답을 핸들링 할 수 있다.
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
                    log.info("### Custom POST Filter: response code -> {}", response.getStatusCode())));
        });
    }

    @Data
    public static class Config {
        private boolean usePreLogger;
        private boolean usePostLogger;
        private String message;
    }
}
