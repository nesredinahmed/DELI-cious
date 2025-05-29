package com.delicous.view;

import com.delicous.model.Chips;
import com.delicous.model.Order;
import com.delicous.utilities.Menu; // Import the new Menu class

import java.util.List;
import java.util.Scanner;

/**
 * Screen for adding chips to the order.
 */
public class AddChipsScreen implements Screen {
    private Order currentOrder;
    // Removed hardcoded list, now using Menu class
    // private static final List<String> CHIP_TYPES = Arrays.asList("Original", "Salt & Vinegar", "BBQ", "Cheddar", "Sour Cream & Onion");

    public AddChipsScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        // No initial display, handled by handleInput's step-by-step prompts
    }

    @Override
    public String handleInput(Scanner scanner) {
        System.out.println("\n--- Add Chips ---");

        // 1. Select Chip Type
        String chipType = selectOption(scanner, "Select chip type:", Menu.getChipTypes());
        if (chipType == null) return "order"; // User cancelled

        Chips chips = new Chips(chipType);
        currentOrder.addItem(chips);
        System.out.println("Chips added to order: " + chips.getDetails());
        return "order"; // Return to order screen
    }

    /**
     * Helper method to prompt user for selection from a list of options.
     * @param scanner Scanner for input.
     * @param prompt The message to display to the user.
     * @param options The list of available options.
     * @return The selected option string, or null if user cancels.
     */
    private String selectOption(Scanner scanner, String prompt, List<String> options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ") " + options.get(i));
            }
            System.out.println("0) Cancel");
            System.out.print("Enter choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    System.out.println("Operation cancelled.");
                    return null;
                }
                if (choice > 0 && choice <= options.size()) {
                    return options.get(choice - 1);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}