package com.delicous.view;

import java.util.Scanner;

/**
 * Represents the Home Screen of the DELI-cious application.
 * Allows the user to start a new order or exit the application.
 */
public class HomeScreen implements Screen {

    @Override
    public void display() {
        System.out.println("\n--- DELI-cious Home Screen ---");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return "home"; // Stay on home screen
        }

        switch (choice) {
            case 1:
                return "order"; // Navigate to Order Screen
            case 0:
                return "exit";  // Exit the application
            default:
                System.out.println("Invalid choice. Please try again.");
                return "home"; // Stay on home screen
        }
    }
}