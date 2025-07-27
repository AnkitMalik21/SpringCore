package com.hcl.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
     private EasyBank easyBank;
     
     public EasyBank getEasyBank() {
    	 return easyBank;
     }
     
     @Autowired
     public void setEasyBank(EasyBank easyBank) {
    	 this.easyBank = easyBank;
     }
     
     @Around(value="execution(public void com.hcl.Aop.EasyBank.doWithdraw(..))")
     public void validateWithdraw(ProceedingJoinPoint joinPoint) throws Throwable{
    	 //validate the entered pin before proceeding with withdrawal
    	 if(easyBank.getTempPin()!= easyBank.getPinCode()) {
    		 throw new Exception("Invalid pin");
    	 }else {
    		 joinPoint.proceed();
    		 System.out.println("Your remaining balance is " + easyBank.getBalance());
    	 }
     }
     
     @Before("execution(public void com.hcl.Aop.EasyBank.showBalance(..)) ||"
     		+ "execution(public void com.hcl.Aop.EasyBank.doDeposit(..))")
     public void validateBalance() {
    	 if(easyBank.getTempPin() != easyBank.getPinCode()) {
    		 throw new RuntimeException("Invalid PIN");
    	 }
     }
     
     @AfterReturning(value="execution(public void com.hcl.Aop.EasyBank.doChangePin(..))")
     public void afterPinChange() {
    	 System.out.println("You have successfully changed your pin");
     }
     
     @AfterThrowing(value="execution(public void com.hcl.Aop.EasyBank)")
     public void afterWrongPin() {
    	 System.out.println("Invalid PIN entered");
     }
}
