package com.minis;

import com.minis.context.ClassPathXmlApplicationContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.net.URL;

public class HelloWorld {
    public static void main(String[] args) throws ClassNotFoundException {
//        SAXReader reader = new SAXReader();
//        try {
//            URL url = "";
//            Document document = reader.read("beans.xml");
//        } catch (DocumentException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Class.forName("com.minis.context.ClassPathXmlApplicationContext").getClassLoader().getResource(""));
        System.out.println("Hello World!");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }
}