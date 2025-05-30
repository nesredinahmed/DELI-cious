package com.delicious.screens;

import com.delicious.model.Order;
import com.delicious.utilities.AnsiColors; // Import AnsiColors

import java.util.Scanner;

/**
 * Represents the Order Screen where customers can add items to their order.
 */
public class OrderScreen implements Screen {
    private Order currentOrder;

    public OrderScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        System.out.println(AnsiColors.BOLD + AnsiColors.GREEN + "\n--- Order Screen ---" + AnsiColors.RESET);
        System.out.println(AnsiColors.BRIGHT_WHITE + "Current Order Items:" + AnsiColors.RESET);
        System.out.println(currentOrder.getDetails()); // Order.getDetails() now includes colors
        System.out.println(AnsiColors.GREEN + "--------------------" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "1) Add Sandwich" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "2) Add Drink" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "3) Add Chips" + AnsiColors.RESET);
        System.out.println(AnsiColors.YELLOW + "4) Checkout" + AnsiColors.RESET);
        System.out.println(AnsiColors.RED + "0) Cancel Order" + AnsiColors.RESET);
        System.out.print(AnsiColors.BRIGHT_BLUE + "Enter your choice: " + AnsiColors.RESET);
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(AnsiColors.RED + "Invalid input. Please enter a number." + AnsiColors.RESET);
            return "order"; // Stay on order screen
        }

        switch (choice) {
            case 1:
                return "add_sandwich";
            case 2:
                return "add_drink";
            case 3:
                return "add_chips";
            case 4:
                if (currentOrder.getItems().isEmpty()) {
                    System.out.println(AnsiColors.RED + "Cannot checkout an empty order. Please add items first." + AnsiColors.RESET);
                    return "order";
                }
                return "checkout";
            case 0:
                System.out.println(AnsiColors.YELLOW + "Order cancelled. Returning to Home Screen." + AnsiColors.RESET);
                return "cancel_order"; // Special command to cancel and go home
            default:
                System.out.println(AnsiColors.RED + "Invalid choice. Please try again." + AnsiColors.RESET);
                return "order"; // Stay on order screen
        }
    }
}