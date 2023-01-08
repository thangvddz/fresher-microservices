package com.fresher.apigetway.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerResponse;

import java.util.logging.Logger;

@Configuration
@Slf4j
public class CustomFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        log.info("Authorization: "+ serverHttpRequest.getHeaders().getFirst("Authorization"));
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            org.springframework.http.server.reactive.ServerHttpResponse response = exchange.getResponse();
            log.info("Post filter : "+response.getStatusCode());
        }));
    }
}
