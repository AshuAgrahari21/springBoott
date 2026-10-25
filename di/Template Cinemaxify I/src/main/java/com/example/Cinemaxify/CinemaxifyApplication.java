
package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class CinemaxifyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Cinemaxify Application");
            System.out.println("Please select the member you want the plan for:");
            System.out.println("1. Self\n2. Spouse\n3. Exit");

            String userType = "";
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> userType = "self";
                case 2 -> userType = "spouse";
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            // Fetch the selected Spring bean
            User user = context.getBean(userType, User.class);

            // Take user details
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            System.out.print("Enter contact number: ");
            Long contact = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            // Set and display the details
            user.setUserDetails(name, age, contact, address);
            user.getUserDetails();

        } finally {
            scanner.close();
            context.close();
        }
    }
}
