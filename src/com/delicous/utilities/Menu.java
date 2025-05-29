package com.delicous.utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utility class to provide static lists of available menu items.
 * This centralizes menu options, making it easier to manage and update.
 */
public class Menu {

    private static final List<String> SANDWICH_SIZES = Collections.unmodifiableList(Arrays.asList("4\"", "8\"", "12\""));
    private static final List<String> BREAD_TYPES = Collections.unmodifiableList(Arrays.asList("white", "wheat", "rye", "wrap"));
    private static final List<String> MEAT_TYPES = Collections.unmodifiableList(Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon"));
    private static final List<String> CHEESE_TYPES = Collections.unmodifiableList(Arrays.asList("american", "provolone", "cheddar", "swiss"));

    // Separated Regular Toppings, Sauces, and Sides
    private static final List<String> REGULAR_TOPPINGS = Collections.unmodifiableList(Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles",
            "guacamole", "mushrooms"
    ));
    private static final List<String> SAUCE_TYPES = Collections.unmodifiableList(Arrays.asList(
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    ));
    private static final List<String> SIDE_TOPPINGS = Collections.unmodifiableList(Arrays.asList(
            "au jus", "sauce" // Assuming "sauce" here means a side dipping sauce, not condiment
    ));


    private static final List<String> DRINK_SIZES = Collections.unmodifiableList(Arrays.asList("Small", "Medium", "Large"));
    private static final List<String> DRINK_FLAVORS = Collections.unmodifiableList(Arrays.asList("Coke", "Pepsi", "Sprite", "Orange Juice", "Water"));
    private static final List<String> CHIP_TYPES = Collections.unmodifiableList(Arrays.asList("Original", "Salt & Vinegar", "BBQ", "Cheddar", "Sour Cream & Onion"));

    public static List<String> getSandwichSizes() {
        return SANDWICH_SIZES;
    }

    public static List<String> getBreadTypes() {
        return BREAD_TYPES;
    }

    public static List<String> getMeatTypes() {
        return MEAT_TYPES;
    }

    public static List<String> getCheeseTypes() {
        return CHEESE_TYPES;
    }

    public static List<String> getRegularToppings() {
        return REGULAR_TOPPINGS;
    }

    public static List<String> getSauceTypes() { // New getter
        return SAUCE_TYPES;
    }

    public static List<String> getSideToppings() { // New getter
        return SIDE_TOPPINGS;
    }

    public static List<String> getDrinkSizes() {
        return DRINK_SIZES;
    }

    public static List<String> getDrinkFlavors() {
        return DRINK_FLAVORS;
    }

    public static List<String> getChipTypes() {
        return CHIP_TYPES;
    }
}