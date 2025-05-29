package com.delicous.view;

import com.delicous.model.Drink;
import com.delicous.model.Order;
import com.delicous.utilities.Menu; // Import the new Menu class

import java.util.List;
import java.util.Scanner;

/**
 * Screen for adding a drink to the order.
 */
public class AddDrinkScreen implements Screen {
    private Order currentOrder;
    // Removed hardcoded lists, now using Menu class
    // private static final List<String> DRINK_SIZES = Arrays.asList("Small", "Medium", "Large");
    // private static final List<String> DRINK_FLAVORS = Arrays.asList("Coke", "Pepsi", "Sprite", "Orange Juice", "Water");

    public AddDrinkScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        // No initial display, handled by handleInput's step-by-step prompts
    }

    @Override
    public String handleInput(Scanner scanner) {
        System.out.println("\n--- Add Drink ---");

        // 1. Select Drink Size
        String size = selectOption(scanner, "Select drink size:", Menu.getDrinkSizes());
        if (size == null) return "order"; // User cancelled

        // 2. Select Drink Flavor
        String flavor = selectOption(scanner, "Select drink flavor:", Menu.getDrinkFlavors());
        if (flavor == null) return "order"; // User cancelled

        Drink drink = new Drink(flavor, size);
        currentOrder.addItem(drink);
        System.out.println("Drink added to order: " + drink.getDetails());
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