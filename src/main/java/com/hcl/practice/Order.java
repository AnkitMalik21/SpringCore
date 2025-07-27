package com.hcl.practice;

import java.time.LocalDate;
import java.util.List;

public class Order {
     private int orderName;
     private LocalDate orderDate;
     private int totalValue;
     private List<Product> allProducts;
     
     public Order(int orderName,CharSequence orderDate,int totalValue,List<Product> allProducts) {
    	 super();
    	 this.orderName = orderName;
    	 this.orderDate = LocalDate.parse(orderDate);
    	 this.totalValue = totalValue;
    	 this.allProducts = allProducts;
     }
     
     public void display() {
    	 System.out.println(orderName + ", " + orderDate + ", " + totalValue);
    	 for(int i=0;i<allProducts.size();i++) {
    		 System.out.println(allProducts.get(i));
    	 }
     }
     
}
