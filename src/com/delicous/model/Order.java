package com.delicous.model;

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
            details.append("Order is empty.\n");
            return details.toString();
        }

        details.append("--- Current Order Details ---\n");
        for (int i = 0; i < items.size(); i++) {
            Sellable item = items.get(i);
            details.append(String.format("Item %d:\n", i + 1));
            details.append(item.getDetails());
            details.append("\n");
        }
        details.append("-----------------------------\n");
        details.append(String.format("Subtotal: $%.2f\n", calculateTotal()));
        return details.toString();
    }
}