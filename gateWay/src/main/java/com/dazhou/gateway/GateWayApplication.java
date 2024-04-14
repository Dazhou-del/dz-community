package com.dazhou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-14 20:27
 */
@SpringBootApplication
@ComponentScan("com.dazhou")
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
