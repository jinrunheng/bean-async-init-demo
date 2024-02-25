package com.github.config;

import com.github.spring.AsyncTaskExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午6:30
 * @Version 1.0
 */
@Configuration
public class AsyncBeanConfig {
    /**
     * Bean 异步初始化
     *
     * @return
     */
    @Bean
    public AsyncTaskExecutionListener asyncTaskExecutionListener() {
        return new AsyncTaskExecutionListener();
    }
}
