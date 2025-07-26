package com.hcl.autoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
/* @ComponentScan("com.hcl.autoConfig") */
public class AppConfig {
    @Bean
    public Address HomeAddress() {
    	Address address = new Address();
    	address.setAddressLine1("HOUSE NO. 1");
    	address.setCity("NEW DELHI");
    	address.setState("delhi");
    	address.setCountry("India");
    	return address;
    }
    
    @Bean
    public Employee employee() {
    	Employee employee = new Employee();
    	employee.setId(1);
    	employee.setName("Ankit ji");
    	employee.setAddress(HomeAddress());
    	return employee;
    }
}
