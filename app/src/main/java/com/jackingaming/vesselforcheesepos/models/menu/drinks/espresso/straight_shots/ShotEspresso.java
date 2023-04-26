package com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.straight_shots;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.Espresso;

public class ShotEspresso extends Espresso {
    public static final String TAG = ShotEspresso.class.getSimpleName();

    public static final String NAME_DEFAULT = "Shot of espresso";
    public static final String DESCRIPTION_DEFAULT = "beans are measured, grinded, then pulled with triple filtered h20";
    public static final double PRICE_SMALL_DEFAULT = 0.75;
    public static final double PRICE_MEDIUM_DEFAULT = 1.40;
    public static final double PRICE_LARGE_DEFAULT = 1.95;
    public static final boolean ICED_DEFAULT = false;

    public ShotEspresso() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_SMALL_DEFAULT, ICED_DEFAULT);
    }
}
