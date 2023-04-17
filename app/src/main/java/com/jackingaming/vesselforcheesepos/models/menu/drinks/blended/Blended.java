package com.jackingaming.vesselforcheesepos.models.menu.drinks.blended;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Blended extends Drink {
    public static final String TAG = Blended.class.getSimpleName();

    public Blended() {
    }

    public Blended(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
