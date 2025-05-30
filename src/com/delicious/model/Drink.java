package com.delicious.model;

import com.delicious.utilities.PriceList;

/**
 * Represents a drink that can be added to an order.
 */
public class Drink implements Sellable {
    private String flavor;
    private String size; // Small, Medium, Large

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return PriceList.getDrinkPrice(size);
    }

    @Override
    public String getDetails() {
        return String.format("%s %s - $%.2f", size, flavor, getPrice());
    }
}