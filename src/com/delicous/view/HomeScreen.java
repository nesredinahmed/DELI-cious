package com.delicous.view;

import com.delicous.utilities.AnsiColors; // Import AnsiColors
import java.util.Scanner;

/**
 * Represents the Home Screen of the DELI-cious application.
 * Allows the user to start a new order or exit the application.
 */
public class HomeScreen implements Screen {

    @Override
    public void display() {
        System.out.println(AnsiColors.BOLD + AnsiColors.GREEN + "\n--- DELI-cious Home Screen ---" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "1) New Order" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "0) Exit" + AnsiColors.RESET);
        System.out.print(AnsiColors.BRIGHT_BLUE + "Enter your choice: " + AnsiColors.RESET);
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(AnsiColors.RED + "Invalid input. Please enter a number." + AnsiColors.RESET);
            return "home"; // Stay on home screen
        }

        switch (choice) {
            case 1:
                return "order"; // Navigate to Order Screen
            case 0:
                return "exit";  // Exit the application
            default:
                System.out.println(AnsiColors.RED + "Invalid choice. Please try again." + AnsiColors.RESET);
                return "home"; // Stay on home screen
        }
    }
}