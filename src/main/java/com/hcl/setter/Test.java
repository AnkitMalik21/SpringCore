package com.hcl.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
     public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e1 = (Employee) context.getBean("obj1");
		Employee e2 = (Employee) context.getBean("obj2");
		
		e1.display();
		e2.display();
		
	}
}
