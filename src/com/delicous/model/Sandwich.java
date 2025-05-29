package com.delicous.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a customizable sandwich.
 */
public class Sandwich implements Sellable {
    private String size; // 4", 8", 12"
    private Bread bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, Bread bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public String getSize() {
        return size;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    /**
     * Adds a topping to the sandwich.
     * @param topping The topping to add.
     */
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double totalPrice = bread.getPrice(size); // Base price includes bread

        // Add price for premium toppings and extra portions
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice(size);
        }
        return totalPrice;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(String.format("%s Sandwich on %s bread (%.2f)\n", size, bread.getType(), bread.getPrice(size)));

        // Filter and list toppings
        List<Topping> regularToppings = toppings.stream()
                .filter(t -> t instanceof RegularTopping)
                .collect(Collectors.toList());
        List<Topping> premiumToppings = toppings.stream()
                .filter(t -> t instanceof PremiumTopping)
                .collect(Collectors.toList());

        if (!regularToppings.isEmpty()) {
            details.append("  Regular Toppings (Included): ");
            details.append(regularToppings.stream()
                    .map(Topping::toString)
                    .collect(Collectors.joining(", ")));
            details.append("\n");
        }

        if (!premiumToppings.isEmpty()) {
            details.append("  Premium Toppings:\n");
            for (Topping pTopping : premiumToppings) {
                details.append(String.format("    - %s ($%.2f)\n", pTopping.toString(), pTopping.getPrice(size)));
            }
        }

        details.append(String.format("  Toasted: %s\n", toasted ? "Yes" : "No"));
        details.append(String.format("  Sandwich Total: $%.2f\n", getPrice()));
        return details.toString();
    }
}