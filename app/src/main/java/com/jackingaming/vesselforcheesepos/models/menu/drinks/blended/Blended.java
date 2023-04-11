package com.jackingaming.vesselforcheesepos.models.menu.drinks.blended;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Blended extends Drink {
    public Blended() {
    }

    public Blended(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
