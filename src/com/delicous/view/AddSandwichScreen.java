package com.delicous.view;

import com.delicous.model.*;
import com.delicous.utilities.Menu; // Import the new Menu class

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Screen for adding and customizing a sandwich.
 */
public class AddSandwichScreen implements Screen {
    private Order currentOrder;

    public AddSandwichScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        // No initial display, handled by handleInput's step-by-step prompts
    }

    @Override
    public String handleInput(Scanner scanner) {
        System.out.println("\n--- Add Sandwich ---");

        // 1. Select Sandwich Size
        String size = selectOption(scanner, "Select sandwich size:", Menu.getSandwichSizes());
        if (size == null) return "order"; // User cancelled

        // 2. Select Bread Type
        String breadType = selectOption(scanner, "Select your bread:", Menu.getBreadTypes());
        if (breadType == null) return "order"; // User cancelled
        Bread bread = new Bread(breadType);

        Sandwich sandwich = new Sandwich(size, bread);

        // 3. Add Meats
        addPremiumToppings(scanner, sandwich, Menu.getMeatTypes(), "Meat", Meat.class);

        // 4. Add Cheeses
        addPremiumToppings(scanner, sandwich, Menu.getCheeseTypes(), "Cheese", Cheese.class);

        // 5. Add Regular Toppings
        addRegularToppings(scanner, sandwich, Menu.getRegularToppings(), "Regular Toppings");

        // 6. Add Sauces
        addRegularToppings(scanner, sandwich, Menu.getSauceTypes(), "Sauces");

        // 7. Add Sides
        addRegularToppings(scanner, sandwich, Menu.getSideToppings(), "Sides");

        // 8. Toasted?
        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        String toastedInput = scanner.nextLine().trim().toLowerCase();
        sandwich.setToasted(toastedInput.equals("yes"));

        currentOrder.addItem(sandwich);
        System.out.println("Sandwich added to order!");
        System.out.println(sandwich.getDetails()); // Show details of the added sandwich
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

    /**
     * Helper method to add premium toppings (meat/cheese) to a sandwich.
     * @param scanner Scanner for input.
     * @param sandwich The sandwich to add toppings to.
     * @param availableToppings List of available topping names.
     * @param toppingCategory Name of the category (e.g., "Meat", "Cheese").
     * @param toppingClass The class of the premium topping (e.g., Meat.class, Cheese.class).
     */
    private <T extends PremiumTopping> void addPremiumToppings(Scanner scanner, Sandwich sandwich,
                                                               List<String> availableToppings,
                                                               String toppingCategory, Class<T> toppingClass) {
        while (true) {
            System.out.println("\n--- Add " + toppingCategory + " ---");
            System.out.println("Available " + toppingCategory + "s:");
            for (int i = 0; i < availableToppings.size(); i++) {
                System.out.println((i + 1) + ") " + availableToppings.get(i));
            }
            System.out.println("0) Done adding " + toppingCategory);
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break; // Done adding this category
                }
                if (choice > 0 && choice <= availableToppings.size()) {
                    String selectedToppingName = availableToppings.get(choice - 1);

                    System.out.print("Would you like extra " + selectedToppingName + "? (yes/no): ");
                    String extraInput = scanner.nextLine().trim().toLowerCase();
                    boolean isExtra = extraInput.equals("yes");

                    T topping;
                    if (toppingClass == Meat.class) {
                        topping = (T) new Meat(selectedToppingName, isExtra);
                    } else if (toppingClass == Cheese.class) {
                        topping = (T) new Cheese(selectedToppingName, isExtra);
                    } else {
                        throw new IllegalArgumentException("Unsupported topping class: " + toppingClass.getName());
                    }
                    sandwich.addTopping(topping);
                    System.out.println(topping.toString() + " added.");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.err.println("Error creating topping: " + e.getMessage());
            }
        }
    }

    /**
     * Helper method to add regular toppings (including sauces and sides) to a sandwich.
     * @param scanner Scanner for input.
     * @param sandwich The sandwich to add toppings to.
     * @param availableItems List of available item names for this category.
     * @param categoryName Name of the category (e.g., "Regular Toppings", "Sauces", "Sides").
     */
    private void addRegularToppings(Scanner scanner, Sandwich sandwich, List<String> availableItems, String categoryName) {
        while (true) {
            System.out.println("\n--- Add " + categoryName + " (Included) ---");
            System.out.println("Available " + categoryName + ":");
            for (int i = 0; i < availableItems.size(); i++) {
                System.out.println((i + 1) + ") " + availableItems.get(i));
            }
            System.out.println("0) Done adding " + categoryName);
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break; // Done adding this category
                }
                if (choice > 0 && choice <= availableItems.size()) {
                    String selectedItemName = availableItems.get(choice - 1);
                    // Regular toppings don't have extra cost, so 'isExtra' is just for display
                    sandwich.addTopping(new RegularTopping(selectedItemName, false));
                    System.out.println(selectedItemName + " added.");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}