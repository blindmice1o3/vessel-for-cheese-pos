package com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;

public abstract class Espresso extends Drink {
    public enum Type {SHOT, CAPPUCCINO, FLAT_WHITE, LATTE, MACCHIATO;}

    // TODO: numberOfShots field

    public Espresso() {
    }

    public Espresso(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
