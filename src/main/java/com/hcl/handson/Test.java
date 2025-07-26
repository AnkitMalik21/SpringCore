package com.hcl.handson;

import java.lang.reflect.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("handson.xml");
		MemberShip m1 = (MemberShip) context.getBean("obj1");
		MemberShip m2 = (MemberShip) context.getBean("obj2");
		
		m1.display();
		m2.display();
	}
}
