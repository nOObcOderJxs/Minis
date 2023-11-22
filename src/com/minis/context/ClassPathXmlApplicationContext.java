package com.minis.context;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext{
    Map<String, Object> singletonMap = new HashMap<>();
    List<String> beanNames = new ArrayList<>();
    public ClassPathXmlApplicationContext(String fileName) {

    }

    public Object getBean(String beanName) throws Exception {
        if(!beanNames.contains(beanName)) {
            throw new Exception("No bean found");
        }
        return singletonMap.get(beanName);
    }
}
