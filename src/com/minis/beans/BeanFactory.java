package com.minis.beans;

public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    Boolean containsBean(String name);

    void registerBean(String beanName, Object obj);
}
