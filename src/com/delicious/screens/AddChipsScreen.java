package com.delicious.screens;

import com.delicious.model.Chips;
import com.delicious.model.Order;
import com.delicious.utilities.AnsiColors; // Import AnsiColors
import com.delicious.utilities.Menu;

import java.util.List;
import java.util.Scanner;

/**
 * Screen for adding chips to the order.
 */
public class AddChipsScreen implements Screen {
    private Order currentOrder;

    public AddChipsScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        // No initial display, handled by handleInput's step-by-step prompts
    }

    @Override
    public String handleInput(Scanner scanner) {
        System.out.println(AnsiColors.BOLD + AnsiColors.GREEN + "\n--- Add Chips ---" + AnsiColors.RESET);

        // 1. Select Chip Type
        String chipType = selectOption(scanner, AnsiColors.BRIGHT_WHITE + "Select chip type:" + AnsiColors.RESET, Menu.getChipTypes());
        if (chipType == null) return "order"; // User cancelled

        Chips chips = new Chips(chipType);
        currentOrder.addItem(chips);
        System.out.println(AnsiColors.GREEN + "Chips added to order: " + chips.getDetails() + AnsiColors.RESET);
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
                System.out.println(AnsiColors.YELLOW + (i + 1) + ") " + options.get(i) + AnsiColors.RESET);
            }
            System.out.println(AnsiColors.RED + "0) Cancel" + AnsiColors.RESET);
            System.out.print(AnsiColors.BRIGHT_BLUE + "Enter choice: " + AnsiColors.RESET);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    System.out.println(AnsiColors.YELLOW + "Operation cancelled." + AnsiColors.RESET);
                    return null;
                }
                if (choice > 0 && choice <= options.size()) {
                    return options.get(choice - 1);
                } else {
                    System.out.println(AnsiColors.RED + "Invalid choice. Please try again." + AnsiColors.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(AnsiColors.RED + "Invalid input. Please enter a number." + AnsiColors.RESET);
            }
        }
    }
}