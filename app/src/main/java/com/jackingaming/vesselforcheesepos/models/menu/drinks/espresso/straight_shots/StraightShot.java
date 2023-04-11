package com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.straight_shots;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.Espresso;

public abstract class StraightShot extends Espresso {
    public StraightShot() {
    }

    public StraightShot(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
