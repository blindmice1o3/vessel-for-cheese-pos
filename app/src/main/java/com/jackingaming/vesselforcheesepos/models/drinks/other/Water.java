package com.jackingaming.vesselforcheesepos.models.drinks.other;

import com.jackingaming.vesselforcheesepos.models.drinks.Drink;

public class Water extends Drink {
    public static final String NAME_DEFAULT = "water";
    public static final String DESCRIPTION_DEFAULT = "2 part H, 1 part O";
    public static final double PRICE_DEFAULT = 0.01;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public Water() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
