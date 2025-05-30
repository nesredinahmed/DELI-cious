package com.delicious.screens;

import com.delicious.model.Order;
import com.delicious.utilities.AnsiColors; // Import AnsiColors
import com.delicious.utilities.ReceiptLogger;

import java.util.Scanner;

/**
 * Represents the Checkout Screen where the user reviews their order and confirms/cancels.
 */
public class CheckoutScreen implements Screen {
    private Order currentOrder;

    public CheckoutScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        System.out.println(AnsiColors.BOLD + AnsiColors.GREEN + "\n--- Checkout ---" + AnsiColors.RESET);
        System.out.println(currentOrder.getDetails()); // Display full order details (now with colors)
        System.out.println(AnsiColors.GREEN + "--------------------" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "1) Confirm Order (Generate Receipt)" + AnsiColors.RESET);
        System.out.println(AnsiColors.RED + "0) Cancel Order (Return to Home)" + AnsiColors.RESET);
        System.out.print(AnsiColors.BRIGHT_BLUE + "Enter your choice: " + AnsiColors.RESET);
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(AnsiColors.RED + "Invalid input. Please enter a number." + AnsiColors.RESET);
            return "checkout"; // Stay on checkout screen
        }

        switch (choice) {
            case 1:
                ReceiptLogger.saveReceipt(currentOrder);
                System.out.println(AnsiColors.GREEN + "Order confirmed! Receipt generated." + AnsiColors.RESET);
                return "new_order_and_home"; // Special command to create new order and go home
            case 0:
                System.out.println(AnsiColors.YELLOW + "Order cancelled. Returning to Home Screen." + AnsiColors.RESET);
                return "cancel_order_and_home"; // Special command to cancel and go home
            default:
                System.out.println(AnsiColors.RED + "Invalid choice. Please try again." + AnsiColors.RESET);
                return "checkout"; // Stay on checkout screen
        }
    }
}