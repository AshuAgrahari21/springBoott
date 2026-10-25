
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

            while (true) {
                System.out.println(
                        "Please select the member you want the plan for:");
                System.out.println("1. Self\n2. Spouse\n3. Exit");

                String userType;
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

                System.out.println("Please select your plan:");
                System.out.println("1. Normal");
                System.out.println("2. Premium");

                int planChoice = scanner.nextInt();
                scanner.nextLine();

                String myPlan;

                switch (planChoice) {
                    case 1 -> myPlan = "Normal";
                    case 2 -> myPlan = "Premium";
                    default -> {
                        System.out.println("invalid choice");
                        return;
                    }
                }

                String beanId = userType + myPlan;

                User user = context.getBean(beanId, User.class);

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter age: ");
                int age = scanner.nextInt();

                System.out.print("Enter contact number: ");
                Long contact = scanner.nextLong();
                scanner.nextLine();

                System.out.print("Enter address: ");
                String address = scanner.nextLine();

                user.setUserDetails(name, age, contact, address);
                user.getUserDetails();

                System.out.println("Selected plan: "
                        + user.getUserPlan().getPlanName());

                System.out.println(
                        "Do you want to purchase plan for someone else");
                System.out.println("1. Yes");
                System.out.println("2. No");

                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 2) {
                    break;
                }
            }
        } finally {
            scanner.close();
            context.close();
        }
    }
}

