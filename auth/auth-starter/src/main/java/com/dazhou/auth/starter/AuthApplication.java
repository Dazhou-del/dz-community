package com.dazhou.auth.starter;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-14 16:01
 */
@SpringBootApplication
@ComponentScan("com.dazhou")
@MapperScan("com.dazhou.**.mapper")
@EnableEncryptableProperties //开启加密注解
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
