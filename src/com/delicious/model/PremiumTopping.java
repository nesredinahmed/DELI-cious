package com.delicious.model;

/**
 * Abstract base class for premium sandwich toppings (e.g., meats, cheeses).
 * These toppings have an additional cost.
 */
public abstract class PremiumTopping extends Topping {

    public PremiumTopping(String name) {
        super(name);
    }

    public PremiumTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public boolean hasAdditionalCost() {
        return true; // Premium toppings always have an additional cost
    }
}