package com.dazhou.gateway.exception;

import cn.dev33.satoken.exception.SaTokenException;
import com.dazhou.gateway.entity.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * GateWay全局异常处理
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-15 18:20
 */
@Component
public class GateWayExceptionHandler implements ErrorWebExceptionHandler {

    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        Integer code=200;
        String message;
        //如果异常属于SaTokenException
        if (ex instanceof SaTokenException){
            code=401;
            message="无权限";
            ex.printStackTrace();
        }else {
            code=500;
            message="系统繁忙";
            ex.printStackTrace();
        }
        Result result = Result.fail(code, message);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.fromSupplier(()->{
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            byte[] bytes = null;
            try {
                bytes = objectMapper.writeValueAsBytes(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return dataBufferFactory.wrap(bytes);

        }));
    }
}
