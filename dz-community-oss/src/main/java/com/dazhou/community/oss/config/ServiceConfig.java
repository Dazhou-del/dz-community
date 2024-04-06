package com.dazhou.community.oss.config;

import com.dazhou.community.oss.adapter.StorageAdapter;
import com.dazhou.community.oss.adapter.AliYunStorageAdapter;
import com.dazhou.community.oss.adapter.MinoStorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件存储config
 *
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 16:18
 */
@Configuration
public class ServiceConfig {

    @Value("${oss.serviceName}")
    private String serviceName;

    @Bean
    public  StorageAdapter getStorageService() {
        if ("minio".equals(serviceName)) {
            return new MinoStorageAdapter();
        } else if ("aliyun".equals(serviceName)) {
            return new AliYunStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }
}
