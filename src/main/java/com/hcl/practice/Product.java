package com.hcl.practice;

import java.time.LocalDate;

public class Product {
     private int productId;
     private String productName;
     private int productCost;
     private CharSequence manufactoringDate;
     private CharSequence expiryDate;
     
     
     public Product(int productId,String productName,int productCost,
    		 CharSequence manufacoringDate,CharSequence expiryDate) {
    	 super();
    	 this.productId = productId;
    	 this.productName = productName;
    	 this.productCost = productCost;
    	 this.manufactoringDate = manufacoringDate;
    	 this.expiryDate = expiryDate;
     }


	 @Override
	 public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", manufactoringDate=" + manufactoringDate + ", expiryDate=" + expiryDate + "]";
	 }
     
     
}
