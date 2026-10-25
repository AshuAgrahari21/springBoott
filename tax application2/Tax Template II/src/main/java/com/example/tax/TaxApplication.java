
package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Tax Payment Application");

        while (true) {
            System.out.println(
                    "Please select which tax you want to pay: \n"
                    + "1. Income \n2. Property\n3. Exit"
            );

            int userChoice = scanner.nextInt();
            String taxChoice = "";

            switch (userChoice) {
                case 1 -> {
                    // Income tax bean ID
                    taxChoice = "incomeTax";
                }
                case 2 -> {
                    // Property tax bean ID
                    taxChoice = "propertyTax";
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    context.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice");
                    scanner.close();
                    context.close();
                    return;
                }
            }

            // Load the selected bean from Spring
            Tax tax = context.getBean(taxChoice, Tax.class);

            System.out.println(tax.getTaxType());
        }
    }
}

