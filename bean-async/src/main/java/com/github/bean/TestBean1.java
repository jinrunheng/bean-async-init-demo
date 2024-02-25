package com.github.bean;

import com.github.spring.AsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午2:24
 * @Version 1.0
 */
@Slf4j
public class TestBean1 {

//    public void initMethod1() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            log.error("error", ex);
//        }
//    }

    public void initMethod1() {
        AsyncTaskExecutor.submitTask(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                log.error("error", ex);
            }
        });
    }
}
