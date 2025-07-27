package com.hcl.orm.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Crud {
      private static SessionFactory factory;
      
      //static block to initialize sessioinFactory
      
      static {
    	  Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
    	  factory = cfg.buildSessionFactory();
      }
      
      private static Session getSession() {
    	  return factory.openSession();
      }
      
      public void insertEmployee(int id,String firstName,String lastName) {
    	  try(Session session = getSession()){
    		  Transaction transaction = session.beginTransaction();
    		  Employee employee = new Employee();
    		  employee.setId(id);
    		  employee.setFirstName(firstName);
    		  employee.setLastName(lastName);
    		  
    		  session.save(employee); //this is depreciated method;
    		  transaction.commit();
    		  
    		  System.out.println("Recording inserted successfully");
    	  }
      }
      
      public void selectEmployee(int id) {
    	  try(Session session = getSession()){
    		  Employee employee = session.get(Employee.class, id);
    		  
    		  if(employee !=null) {
    			  System.out.println("Id : " + employee.getId());
    			  System.out.println("First Name: " + employee.getFirstName());
    			  System.out.println("Last Name: " + employee.getLastName());
    		  }else {
    			  System.out.println("Employee not found with Id : " + id);
    		  }
    	  }
      }
      
      //method to update an Employee's last name by Id
      public void updateEmployee(int id,String newLastName) {
    	  try(Session session = getSession()){
    		  Transaction transaction = session.beginTransaction();
    		  Employee employee = session.get(Employee.class, id);
    		  
    		  if(employee != null) {
    			  employee.setLastName(newLastName);
    			  session.update(employee);
    			  transaction.commit();
    		  }else {
    			  System.out.println("Employee not found with id: ");
    		  }
    	  }
      }
      
      public void deleteEmployee(int id) {
    	  try(Session session = getSession()){
    		  Transaction transaction = session.beginTransaction();
    		  
    		  Employee employee = session.get(Employee.class, id);
    		  
    		  if(employee != null) {
    			  session.delete(employee);
    			  transaction.commit();
    			  System.out.println("Employee has been deleted successfully");
    		  }else {
    		  }
    		 
    	  }
      }
      public static void closeFactory() {
    	  if(factory != null) {
    		  factory.close();
    		  System.out.println("SessionFactory closed");
    	  }
      }
}
