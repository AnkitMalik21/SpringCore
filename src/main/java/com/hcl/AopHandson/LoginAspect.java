package com.hcl.AopHandson;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
     @Autowired
     private EasyBank easyBank;
     
     //Around advice for doWithdraw
     @Around("execution(*com.hcl.EasyBank.doWithdraw(..))")
     public Object validateWithdraw(ProceedingJoinPoint joinPoint) throws Throwable{
    	 int tempPin = easyBank.getTempPin();
    	 int pinCode = easyBank.getPinCode();
    	 
    	 if(tempPin != pinCode) {
    		 throw new IllegalArgumentException("Invalid pin");
    	 }
    	 //proceed with the withdraw
    	 Object retVal = joinPoint.proceed();
    	 
    	 System.out.println("Your remaining balance is " + easyBank.getBalance());
    	 
    	 return retVal;
     }
     
     //before advice for doDeposit and showBalance
     @Before("execution(*com.hcl.EasyBank.doDeposit(..)) || execution(*com.hcl.EasyBank.showBalance(..))")
     public void validateBalance() throws Exception{
    	 int tempPin = easyBank.getTempPin();
    	 int pinCode = easyBank.getPinCode();
    	 
    	 if(tempPin != pinCode) {
    		 throw new IllegalArgumentException("Invalid Pin");
    	 }
     }
}
