package com.github.config;

import com.alipay.sofa.runtime.api.annotation.SofaAsyncInit;
import com.github.bean.TestBean1;
import com.github.bean.TestBean2;
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
    @SofaAsyncInit
    public TestBean1 testBean1() {
        return new TestBean1();
    }

    @Bean(initMethod = "initMethod2")
    @SofaAsyncInit
    public TestBean2 testBean2() {
        return new TestBean2();
    }
}
