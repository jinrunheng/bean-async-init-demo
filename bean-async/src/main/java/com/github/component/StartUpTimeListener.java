package com.github.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午2:17
 * @Version 1.0
 * @Desc 统计 Spring 容器启动到完成需要耗费的时间
 */
@Component
@Slf4j
public class StartUpTimeListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        long startTime = event.getApplicationContext().getStartupDate();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("---------------- Spring Application started in : " + elapsedTime + "ms ----------------");
    }
}
