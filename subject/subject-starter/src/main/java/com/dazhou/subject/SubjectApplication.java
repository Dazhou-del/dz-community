package com.dazhou.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-14 21:19
 */
@SpringBootApplication
@ComponentScan("com.dazhou")
@MapperScan("com.dazhou.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
