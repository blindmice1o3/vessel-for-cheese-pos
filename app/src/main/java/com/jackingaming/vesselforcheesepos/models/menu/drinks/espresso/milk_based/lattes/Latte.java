package com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.milk_based.MilkBased;

public class Latte extends MilkBased {
    public static final String TAG = "Latte";

    public static final String NAME_DEFAULT = "Latte";
    public static final String DESCRIPTION_DEFAULT = "espresso, steamed milk, light milk foam";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public Latte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
