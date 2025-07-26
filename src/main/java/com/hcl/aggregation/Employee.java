package com.hcl.aggregation;

public class Employee {
     private int id;
     private String name;
     private Address address;
     
	 public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	 }
	 
		/*
		 * this is called a object aggregation ,as this has a relationShip with address
		 */     
     
	 public void display() {
		  System.out.println(id + " " + name);
		  System.out.println(address.city +" "+ address.state +" "+ address.country);
	 }
	 //don't use private in address class
	 //if you use please mention getter and setter
	 
	 public static void main(String[] args) {
	   Address a1 = new Address("chennai","TN","INDIA");
	   Address a2 = new Address("Hydrabad","Telangana","India");
	   
	   Employee e1  = new Employee(1, "Ankit", a1);
	   Employee e2 = new Employee(2,"daya", a2);
	   
	   e1.display();
	   e2.display();
	}
	 
}
