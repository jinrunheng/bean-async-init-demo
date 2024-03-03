package com.github.component;

/**
 * @Author Dooby Kim
 * @Date 2024/3/3 下午9:22
 * @Version 1.0
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class LaunchTimeBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor, MergedBeanDefinitionPostProcessor {

    @Autowired
    private LaunchTimeManager launchInfoManager;

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        launchInfoManager.beanStart(beanName, System.currentTimeMillis());
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        launchInfoManager.beanEnd(beanName, System.currentTimeMillis());
        return bean;
    }

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        // ignore
    }
}
