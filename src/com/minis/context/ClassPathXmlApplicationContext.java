package com.minis.context;

import com.minis.beans.BeanFactory;
import com.minis.beans.SimpleBeanFactory;
import com.minis.beans.XmlBeanDefinitionReader;
import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;

public class ClassPathXmlApplicationContext{
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName){
        Resource resource = new ClassPathXmlResource(fileName);
        beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.instanceBeans(resource);
    }


    public Object getBean(String beanName){
        return beanFactory.getBean(beanName);
    }
}
