package com.hcl.handson;

public class MemberShip {
     private int memberShip;
     private String memberShipType;
     private int visitPerYear;
     private Customer customer;
     
	 public MemberShip(int memberShip, String memberShipType, int visitPerYear, Customer customer) {
		super();
		this.memberShip = memberShip;
		this.memberShipType = memberShipType;
		this.visitPerYear = visitPerYear;
		this.customer = customer;
	 }
     
     public void display() {
    	 System.out.println("Membership: " + memberShip + "MembershipType: " + memberShipType + " ,Visits per year: " + visitPerYear);
    	 System.out.println("Customer "+customer);
     }
}
