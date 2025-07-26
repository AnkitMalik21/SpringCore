package com.hcl.autoConfig;

import org.springframework.stereotype.Component;

@Component // this is a spring managed bean, detected when we run the app
public class Address {
     private String AddressLine1;
     private String city;
     private String state;
     private String country;
     
   //Getter and Setter
     
	 public String getAddressLine1() {
		 return AddressLine1;
	 }
	 public void setAddressLine1(String addressLine1) {
		 AddressLine1 = addressLine1;
	 }
	 public String getCity() {
		 return city;
	 }
	 public void setCity(String city) {
		 this.city = city;
	 }
	 public String getState() {
		 return state;
	 }
	 public void setState(String state) {
		 this.state = state;
	 }
	 public String getCountry() {
		 return country;
	 }
	 public void setCountry(String country) {
		 this.country = country;
	 }
	 
	 // to string method
	 @Override
	 public String toString() {
		return "Address [AddressLine1=" + AddressLine1 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", getAddressLine1()=" + getAddressLine1() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getCountry()=" + getCountry() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	 }
     
     
     
     
     
}
