package com.hcl.AopHandson;

public class EasyBank {
    private int pinCode = 6789; //default pin
    private int balance = 10000;//default balance
    private int tempPin;        //dynamically enterred pin
    
    //Getter and Setter
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getTempPin() {
		return tempPin;
	}
	public void setTempPin(int tempPin) {
		this.tempPin = tempPin;
	}
    
    // Business method
	public void doWithdraw(int amount) {
		if(amount>balance) {
			System.out.println("Insufficient fund");
		}else {
			balance -= amount;
			System.out.println("You have successfully withdrawn " + amount);
		}
	}
	
	public void doDeposit(int amount) {
		balance += amount;
		System.out.println("Your balance is " + balance);
	}
    
	public void doChangePin(int oldPin,int newPin) {
		if(oldPin == pinCode) {
			//check new pin length and first digit
			String np = String.valueOf(newPin);
			if(np.length() == 4 && !np.startsWith("0")) {
				pinCode = newPin;
			}else {
				throw new IllegalArgumentException("NEW PIN must be 4 digits and not start with 0");
			}
		}else {
			throw new IllegalArgumentException("Old PIN does not match");
		}
	}
	
	public void showBalance() {
		System.out.println("Your balance is "+ balance);
	}
    
}
