package com.minis.beans;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>(256);

    @Override
    public Object getBean(String beanName) throws Exception {
        Object singleton = this.singletons.get(beanName);
        if(singletons == null) {
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if(beanDefinition == null) {
                throw new Exception("no Bean");
            }
            singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            this.registerSingleton(beanName, singleton);
        }
        return singletons.get(beanName);
    }

    @Override
    public Boolean containsBean(String name) {
        return containsSingleton(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        registerSingleton(beanName,obj);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) { this.beanDefinitions.put(beanDefinition.getId(), beanDefinition); }
}
