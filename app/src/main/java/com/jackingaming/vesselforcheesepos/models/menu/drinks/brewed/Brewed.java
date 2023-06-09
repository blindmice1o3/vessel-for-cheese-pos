package com.jackingaming.vesselforcheesepos.models.menu.drinks.brewed;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Brewed extends Drink {
    public static final String TAG = Brewed.class.getSimpleName();

    public Brewed() {
    }

    public Brewed(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
