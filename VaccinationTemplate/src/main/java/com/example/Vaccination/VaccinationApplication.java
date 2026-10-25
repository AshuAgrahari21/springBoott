
package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        try (Scanner scanner = new Scanner(System.in)) {

            boolean continueBooking = true;

            while (continueBooking) {

                System.out.println("\n=== Vaccination Application ===");
                System.out.println("Select user:");
                System.out.println("1. Self");
                System.out.println("2. Spouse");
                System.out.println("3. Father");
                System.out.println("4. Mother");
                System.out.println("5. Exit");

                int userChoice = Integer.parseInt(scanner.nextLine());

                if (userChoice == 5) {
                    System.out.println("Exiting application.");
                    break;
                }

                String userType;

                switch (userChoice) {
                    case 1 -> userType = "self";
                    case 2 -> userType = "spouse";
                    case 3 -> userType = "father";
                    case 4 -> userType = "mother";
                    default -> {
                        System.out.println("Invalid user choice.");
                        continue;
                    }
                }

                System.out.println("\nSelect vaccine:");
                System.out.println("1. Covid");
                System.out.println("2. Polio");
                System.out.println("3. Typhoid");

                int vaccineChoice = Integer.parseInt(scanner.nextLine());

                String vaccineType;

                switch (vaccineChoice) {
                    case 1 -> vaccineType = "Covid";
                    case 2 -> vaccineType = "Polio";
                    case 3 -> vaccineType = "Typhoid";
                    default -> {
                        System.out.println("Invalid vaccine choice.");
                        continue;
                    }
                }

                String beanId = userType + vaccineType;

                User user = context.getBean(beanId, User.class);

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter appointment time: ");
                String timeSlot = scanner.nextLine();

                System.out.print("Enter location: ");
                String location = scanner.nextLine();

                System.out.print("Enter appointment date (YYYY-MM-DD): ");
                String date = scanner.nextLine();

                TimeAndLocation appointment =
                        context.getBean("timeAndLocation", TimeAndLocation.class);

                appointment.setDetails(timeSlot, location, date);

                user.setUserDetails(name, age, appointment);

                if (!user.IsVaccinated()) {
                    user.setAppointment();
                    System.out.println("Vaccination status: "
                            + user.IsVaccinated());
                } else {
                    System.out.println(
                            "Vaccination has already been completed for this user and vaccine.");
                }

                System.out.println("\nBook another appointment? (yes/no)");
                String answer = scanner.nextLine();

                continueBooking = answer.equalsIgnoreCase("yes");
            }

        } finally {
            context.close();
        }
    }
}
