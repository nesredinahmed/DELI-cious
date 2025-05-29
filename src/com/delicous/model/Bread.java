package com.delicous.model;

import com.delicous.util.PriceList;

/**
 * Represents a type of bread for a sandwich.
 */
public class Bread {
    private String type;

    public Bread(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * Gets the base price of the bread for a given sandwich size.
     * Note: Bread price is essentially the base sandwich price.
     * @param sandwichSize The size of the sandwich (e.g., "4\"", "8\"", "12\"").
     * @return The base price of the sandwich for this bread type and size.
     */
    public double getPrice(String sandwichSize) {
        return PriceList.getSandwichBasePrice(sandwichSize);
    }

    @Override
    public String toString() {
        return type;
    }
}