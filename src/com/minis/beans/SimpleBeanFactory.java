package com.minis.beans;


import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory{
    Map<String, Object> singletonMap = new HashMap<>();

    @Override
    public Object getBean(String beanName){
        //TODO 为什么这个方法不判断Bean是否存在
//        if(!beanNames.contains(beanName)) {
//            throw new Exception("No bean found");
//        }
        return singletonMap.get(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        try {
            singletonMap.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
