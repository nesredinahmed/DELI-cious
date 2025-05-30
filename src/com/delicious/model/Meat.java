package com.delicious.model;

import com.delicious.utilities.PriceList;

/**
 * Represents a meat topping for a sandwich.
 */
public class Meat extends PremiumTopping {

    public Meat(String name) {
        super(name);
    }

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        if (isExtra()) {
            return PriceList.getExtraMeatPrice(sandwichSize);
        } else {
            return PriceList.getMeatPrice(sandwichSize);
        }
    }
}