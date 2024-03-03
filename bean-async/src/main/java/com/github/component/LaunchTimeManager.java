package com.github.component;

/**
 * @Author Dooby Kim
 * @Date 2024/3/3 下午9:23
 * @Version 1.0
 */

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LaunchTimeManager implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, LaunchTime> launchTimeMap = new ConcurrentHashMap<>();

    public void beanStart(String beanName, Long startTime) {
        if (Objects.nonNull(launchTimeMap.get(beanName))) {
            System.out.printf("------------%s Bean重复启动 -------------\n", beanName);
            return;
        }
        LaunchTime launchTime = new LaunchTime();
        launchTime.setBeanName(beanName);
        launchTime.setStartTime(startTime);
        launchTimeMap.putIfAbsent(beanName, launchTime);
    }

    public void beanEnd(String beanName, Long endTime) {
        if (Objects.isNull(launchTimeMap.get(beanName))) {
            System.out.printf("------------%s Bean还未启动 -------------\n", beanName);
            return;
        }
        launchTimeMap.computeIfPresent(beanName, (k, v) -> {
            v.setEndTime(endTime);
            return v;
        });
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Spring容器启动完成");

        launchTimeMap.values().stream()
                .sorted((e1, e2) -> Long.valueOf(e2.getCostTime() - e1.getCostTime()).intValue())
                .filter(launchTime -> launchTime.getCostTime() > 200)
                .limit(10)
                .forEach(e -> {
                    System.out.printf("启动耗时, beanName:%s, cost:%s \n", e.getBeanName(), e.getCostTime());
                });
    }

    /**
     * Bean启动时间
     */
    public static class LaunchTime {
        private String beanName;

        private Long startTime;

        private Long endTime;

        public String getBeanName() {
            return beanName;
        }

        public void setBeanName(String beanName) {
            this.beanName = beanName;
        }

        public Long getStartTime() {
            return startTime;
        }

        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }

        public Long getEndTime() {
            return endTime;
        }

        public void setEndTime(Long endTime) {
            this.endTime = endTime;
        }

        public Long getCostTime() {
            return endTime - startTime;
        }
    }
}


