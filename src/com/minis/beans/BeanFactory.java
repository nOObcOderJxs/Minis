package com.minis.beans;

public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(BeanDefinition beanDefinition);
}
