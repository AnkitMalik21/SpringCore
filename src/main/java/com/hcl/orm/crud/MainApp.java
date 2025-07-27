package com.hcl.orm.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
     public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Ankit");
		emp.setLastName("Malik");
		
		session.save(emp);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
