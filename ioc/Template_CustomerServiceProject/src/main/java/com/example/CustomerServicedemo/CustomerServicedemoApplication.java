
package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "ApplicationContext.xml");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to Customer Service!");

            System.out.println("Select a department:");
            System.out.println("1. Payment Department");
            System.out.println("2. Query Department");
            System.out.println("3. Sales Department");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String beanId;

            switch (choice) {
                case 1:
                    beanId = "paymentDepartment";
                    break;
                case 2:
                    beanId = "queryDepartment";
                    break;
                case 3:
                    beanId = "salesDepartment";
                    break;
                default:
                    System.out.println("Invalid department choice.");
                    return;
            }

            CustomerCare customerCare =
                    context.getBean(beanId, CustomerCare.class);

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            customerCare.setCustomerName(name);
            customerCare.getService();

            System.out.print("Describe your issue: ");
            String problem = scanner.nextLine();

            customerCare.setProblem(problem);
            customerCare.getProblem();

        } finally {
            context.close();
        }
    }
}
