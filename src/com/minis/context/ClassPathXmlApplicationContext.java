package com.minis.context;


import com.minis.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext{
    Map<String, Object> singletonMap = new HashMap<>();
    List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
    public ClassPathXmlApplicationContext(String fileName){
        this.readXml(fileName);
        this.instanceBeans();
    }

    private void instanceBeans() {
        //通过反射初始化对象
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletonMap.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void readXml(String fileName) {
        SAXReader reader = new SAXReader();
        try {
            URL url = this.getClass().getClassLoader().getResource(fileName);
            Document document = reader.read(url);
            Element rootElement = document.getRootElement();
            for (Element element : (List<Element>)rootElement.elements()) {
                //强制转化(List<Element>) 向下转换，如果不是这样的话会报ClassCastException
                String beanID = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String beanName){
        //TODO 为什么这个方法不判断Bean是否存在
//        if(!beanNames.contains(beanName)) {
//            throw new Exception("No bean found");
//        }
        return singletonMap.get(beanName);
    }
}
