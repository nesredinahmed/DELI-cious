package com.delicious.model;

/**
 * Represents a regular sandwich topping (e.g., lettuce, tomatoes).
 * These toppings are included in the base sandwich price and have no additional cost.
 */
public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name);
    }

    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
        // Regular toppings don't have extra cost for 'extra' portions
        // The 'isExtra' flag here is just for display purposes in getDetails()
        // but doesn't affect price.
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0.0; // Regular toppings are included
    }

    @Override
    public boolean hasAdditionalCost() {
        return false; // Regular toppings do not have additional cost
    }
}