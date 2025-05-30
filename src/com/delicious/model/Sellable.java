package com.delicious.model;

/**
 * Interface for all items that can be sold and added to an order.
 */
public interface Sellable {
    /**
     * Calculates the price of the sellable item.
     * @return The price of the item.
     */
    double getPrice();

    /**
     * Provides a detailed string representation of the sellable item.
     * @return A string detailing the item.
     */
    String getDetails();
}