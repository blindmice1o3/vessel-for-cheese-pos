package com.jackingaming.vesselforcheesepos.models.menu.drinks.other;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Other extends Drink {
    public Other() {
        super();
    }

    public Other(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
