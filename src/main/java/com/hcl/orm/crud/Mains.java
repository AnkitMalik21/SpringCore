package com.hcl.orm.crud;

import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        Crud crud = new Crud();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n==== Hibernate Crud Operation ====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Select Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Insert Operation
                    System.out.print("Enter Employee Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    crud.insertEmployee(id, firstName, lastName);
                    break;

                case 2: // Select Operation
                    System.out.print("Enter Employee Id to select: ");
                    int selectId = scanner.nextInt();
                    crud.selectEmployee(selectId);
                    break;

                case 3: // Update Operation
                    System.out.print("Enter Employee Id to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter new Last Name: ");
                    String newLastName = scanner.nextLine();

                    crud.updateEmployee(updateId, newLastName);
                    break;

                case 4: // Delete Operation (Assuming you add this method in Crud)
                    System.out.print("Enter Employee Id to delete: ");
                    int deleteId = scanner.nextInt();
                    crud.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
        Crud.closeFactory();
    }
}
