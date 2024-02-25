package com.github.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午2:25
 * @Version 1.0
 */
@Slf4j
public class TestBean2 {

    public void initMethod2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            log.error("error", ex);
        }
    }
}
