package com.jackingaming.vesselforcheesepos.models.menu.drinks.tea;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Tea extends Drink {
    public Tea() {
    }

    public Tea(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
