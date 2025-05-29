package com.delicous.util;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    // Sandwich bread base prices by size
    private static final Map<String, Double> SANDWICH_BASE_PRICES = new HashMap<>();
    static {
        SANDWICH_BASE_PRICES.put("4\"", 5.50);
        SANDWICH_BASE_PRICES.put("8\"", 7.00);
        SANDWICH_BASE_PRICES.put("12\"", 8.50);
    }

    // Meat topping prices by size
    private static final Map<String, Double> MEAT_PRICES = new HashMap<>();
    static {
        MEAT_PRICES.put("4\"", 1.00);
        MEAT_PRICES.put("8\"", 2.00);
        MEAT_PRICES.put("12\"", 3.00);
    }

    // Extra meat topping prices by size
    private static final Map<String, Double> EXTRA_MEAT_PRICES = new HashMap<>();
    static {
        EXTRA_MEAT_PRICES.put("4\"", 0.50);
        EXTRA_MEAT_PRICES.put("8\"", 1.00);
        EXTRA_MEAT_PRICES.put("12\"", 1.50);
    }

    // Cheese topping prices by size
    private static final Map<String, Double> CHEESE_PRICES = new HashMap<>();
    static {
        CHEESE_PRICES.put("4\"", 0.75);
        CHEESE_PRICES.put("8\"", 1.50);
        CHEESE_PRICES.put("12\"", 2.25);
    }

    // Extra cheese topping prices by size
    private static final Map<String, Double> EXTRA_CHEESE_PRICES = new HashMap<>();
    static {
        EXTRA_CHEESE_PRICES.put("4\"", 0.30);
        EXTRA_CHEESE_PRICES.put("8\"", 0.60);
        EXTRA_CHEESE_PRICES.put("12\"", 0.90);
    }

    // Drink prices by size
    private static final Map<String, Double> DRINK_PRICES = new HashMap<>();
    static {
        DRINK_PRICES.put("Small", 2.00);
        DRINK_PRICES.put("Medium", 2.50);
        DRINK_PRICES.put("Large", 3.00);
    }

    // Chips price (fixed)
    private static final double CHIPS_PRICE = 1.50;

    /**
     * Retrieves the base price for a sandwich of a given size.
     * @param size The size of the sandwich (e.g., "4\"", "8\"", "12\"").
     * @return The base price of the sandwich.
     */
    public static double getSandwichBasePrice(String size) {
        return SANDWICH_BASE_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for a meat topping of a given sandwich size.
     * @param size The size of the sandwich.
     * @return The price of the meat topping.
     */
    public static double getMeatPrice(String size) {
        return MEAT_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for an extra meat topping of a given sandwich size.
     * @param size The size of the sandwich.
     * @return The price of the extra meat topping.
     */
    public static double getExtraMeatPrice(String size) {
        return EXTRA_MEAT_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for a cheese topping of a given sandwich size.
     * @param size The size of the sandwich.
     * @return The price of the cheese topping.
     */
    public static double getCheesePrice(String size) {
        return CHEESE_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for an extra cheese topping of a given sandwich size.
     * @param size The size of the sandwich.
     * @return The price of the extra cheese topping.
     */
    public static double getExtraCheesePrice(String size) {
        return EXTRA_CHEESE_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for a drink of a given size.
     * @param size The size of the drink (e.g., "Small", "Medium", "Large").
     * @return The price of the drink.
     */
    public static double getDrinkPrice(String size) {
        return DRINK_PRICES.getOrDefault(size, 0.0);
    }

    /**
     * Retrieves the price for chips.
     * @return The price of chips.
     */
    public static double getChipsPrice() {
        return CHIPS_PRICE;
    }
}