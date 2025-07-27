package com.hcl.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("Product.xml");
	    Order p1 = (Order) context.getBean("obj1");
	    p1.display();
	    		
	}
}
