package com.delicous.model;

/**
 * Abstract base class for all sandwich toppings.
 */
public abstract class Topping {
    protected String name;
    protected boolean isExtra; // Indicates if this specific topping instance is an 'extra' portion

    public Topping(String name) {
        this.name = name;
        this.isExtra = false; // Default to not extra
    }

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    /**
     * Calculates the price of the topping for a given sandwich size.
     * This method must be implemented by concrete topping classes.
     * @param sandwichSize The size of the sandwich.
     * @return The price of the topping.
     */
    public abstract double getPrice(String sandwichSize);

    /**
     * Indicates if this topping incurs an additional cost (e.g., premium toppings, extra portions).
     * This method must be implemented by concrete topping classes.
     * @return true if the topping has an additional cost, false otherwise.
     */
    public abstract boolean hasAdditionalCost();

    @Override
    public String toString() {
        return name + (isExtra ? " (Extra)" : "");
    }
}