package com.delicous.model;

import com.delicous.utilities.PriceList;

/**
 * Represents a bag of chips that can be added to an order.
 */
public class Chips implements Sellable {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return PriceList.getChipsPrice();
    }

    @Override
    public String getDetails() {
        return String.format("%s Chips - $%.2f", type, getPrice());
    }
}