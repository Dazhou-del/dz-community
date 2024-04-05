package com.dazhou.community.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio配置类
 *
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 1:45
 */
@Configuration
public class MinioConfig {
    /**
     * Minio地址
     */
    @Value("${minio.url}")
    private String url;

    /**
     * 用户账号
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * 用户密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 获取Minio客户端
     *
     * @return
     */
    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }
}
