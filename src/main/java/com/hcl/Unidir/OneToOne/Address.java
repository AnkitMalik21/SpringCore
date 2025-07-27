package com.hcl.Unidir.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="address_id")
      private Long id;
      
      private String street;
      private String city;
	  public Long getId() {
		  return id;
	  }
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public String getStreet() {
		  return street;
	  }
	  public void setStreet(String street) {
		  this.street = street;
	  }
	  public String getCity() {
		  return city;
	  }
	  public void setCity(String city) {
		  this.city = city;
	  }
	  
	  //to string
	  
	  @Override
	  public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + "]";
	  }
      
      
      
}
