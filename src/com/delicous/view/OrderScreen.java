package com.delicous.view;

import com.delicous.model.Order;

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
        System.out.println("\n--- Order Screen ---");
        System.out.println("Current Order Items:");
        if (currentOrder.getItems().isEmpty()) {
            System.out.println("  (No items added yet)");
        } else {
            System.out.println(currentOrder.getDetails());
        }
        System.out.println("--------------------");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Enter your choice: ");
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
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
                    System.out.println("Cannot checkout an empty order. Please add items first.");
                    return "order";
                }
                return "checkout";
            case 0:
                System.out.println("Order cancelled. Returning to Home Screen.");
                return "cancel_order"; // Special command to cancel and go home
            default:
                System.out.println("Invalid choice. Please try again.");
                return "order"; // Stay on order screen
        }
    }
}