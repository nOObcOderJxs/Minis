package com.minis.beans;


import com.minis.core.Resource;

import org.dom4j.Element;
import java.util.List;

public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void instanceBeans(Resource resource) {
        //通过反射初始化对象
        while (resource.hasNext()) {
            Element element = (Element)resource.next();
            //强制转化(List<Element>) 向下转换，如果不是这样的话会报ClassCastException
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            try {
                beanFactory.registerBean(beanID, Class.forName(beanClassName).newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
