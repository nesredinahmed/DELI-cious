package com.delicous.model;

import com.delicous.utilities.AnsiColors; // Import AnsiColors
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order, containing multiple sellable items.
 */
public class Order {
    private List<Sellable> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a sellable item to the order.
     * @param item The item to add (Sandwich, Drink, or Chips).
     */
    public void addItem(Sellable item) {
        this.items.add(item);
    }

    public List<Sellable> getItems() {
        return items;
    }

    /**
     * Calculates the total cost of all items in the order.
     * @return The total cost.
     */
    public double calculateTotal() {
        return items.stream().mapToDouble(Sellable::getPrice).sum();
    }

    /**
     * Provides a detailed string representation of the entire order.
     * @return A string detailing all items and their costs.
     */
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        if (items.isEmpty()) {
            details.append(AnsiColors.BRIGHT_BLACK + "  (No items added yet)\n" + AnsiColors.RESET);
            return details.toString();
        }

        details.append(AnsiColors.BLUE + "--- Current Order Details ---\n" + AnsiColors.RESET);
        for (int i = 0; i < items.size(); i++) {
            Sellable item = items.get(i);
            details.append(String.format(AnsiColors.WHITE + "Item %d:\n" + AnsiColors.RESET, i + 1));
            details.append(item.getDetails());
            details.append("\n");
        }
        details.append(AnsiColors.BLUE + "-----------------------------\n" + AnsiColors.RESET);
        details.append(String.format(AnsiColors.BRIGHT_CYAN + AnsiColors.BOLD + "Total Order Cost: $%.2f\n" + AnsiColors.RESET, calculateTotal()));
        return details.toString();
    }
}