package com.github.config;

import com.github.bean.TestBean1;
import com.github.bean.TestBean2;
import com.github.spring.AsyncTaskExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午2:33
 * @Version 1.0
 */
@Configuration
public class TestBeanInitConfig {

    @Bean(initMethod = "initMethod1")
    public TestBean1 testBean1() {
        return new TestBean1();
    }

    @Bean(initMethod = "initMethod2")
    public TestBean2 testBean2() {
        return new TestBean2();
    }
}
