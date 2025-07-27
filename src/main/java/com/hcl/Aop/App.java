package com.hcl.Aop;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        EasyBank bank = context.getBean(EasyBank.class);

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int pin = 0;
        int amount = 0;

        do {
            System.out.println("\n---- Select Option ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Change Pin");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Read user input for choice
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next(); // clear invalid input
                continue;  // restart loop
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Enter amount to deposit: ");
                        amount = sc.nextInt();
                        System.out.print("Enter pin: ");
                        pin = sc.nextInt();
                        bank.setTempPin(pin);
                        bank.doDeposit(amount);
                        break;
                    }

                    case 2: {
                        System.out.print("Enter amount to withdraw: ");
                        amount = sc.nextInt();
                        System.out.print("Enter pin: ");
                        pin = sc.nextInt();
                        bank.setTempPin(pin);
                        bank.doWithdraw(amount);  // Corrected here
                        break;
                    }

                    case 3: {
                        System.out.print("Enter your current pin: ");
                        int oldPin = sc.nextInt();
                        System.out.print("Enter 4 digit new pin: ");
                        pin = sc.nextInt();
                        bank.doChangePin(oldPin, pin);
                        break;
                    }

                    case 4: {
                        System.out.print("Enter pin: ");
                        pin = sc.nextInt();
                        bank.setTempPin(pin);
                        bank.showBalance();
                        break;
                    }

                    case 5: {
                        System.out.println("Thanks for using our service.");
                        break;
                    }

                    default: {
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
