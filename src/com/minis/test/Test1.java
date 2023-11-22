package com.minis.test;

import com.minis.context.ClassPathXmlApplicationContext;

public class Test1 {


	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AService service = (AServiceImpl)context.getBean("aservice");
		service.sayHello();
	}

}
