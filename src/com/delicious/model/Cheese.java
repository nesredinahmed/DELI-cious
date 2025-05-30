package com.delicious.model;

import com.delicious.utilities.PriceList;

/**
 * Represents a cheese topping for a sandwich.
 */
public class Cheese extends PremiumTopping {

    public Cheese(String name) {
        super(name);
    }

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        if (isExtra()) {
            return PriceList.getExtraCheesePrice(sandwichSize);
        } else {
            return PriceList.getCheesePrice(sandwichSize);
        }
    }
}