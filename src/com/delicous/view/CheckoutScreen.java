package com.delicous.view;

import com.delicous.model.Order;
import com.delicous.utilities.ReceiptLogger;

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
        System.out.println("\n--- Checkout ---");
        System.out.println(currentOrder.getDetails()); // Display full order details
        System.out.println("--------------------");
        System.out.println("1) Confirm Order (Generate Receipt)");
        System.out.println("0) Cancel Order (Return to Home)");
        System.out.print("Enter your choice: ");
    }

    @Override
    public String handleInput(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return "checkout"; // Stay on checkout screen
        }

        switch (choice) {
            case 1:
                ReceiptLogger.saveReceipt(currentOrder);
                System.out.println("Order confirmed! Receipt generated.");
                return "new_order_and_home"; // Special command to create new order and go home
            case 0:
                System.out.println("Order cancelled. Returning to Home Screen.");
                return "cancel_order_and_home"; // Special command to cancel and go home
            default:
                System.out.println("Invalid choice. Please try again.");
                return "checkout"; // Stay on checkout screen
        }
    }
}