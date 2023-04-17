package com.jackingaming.vesselforcheesepos.models.menu.drinks.other;

public class Water extends Other {
    public static final String TAG = Water.class.getSimpleName();

    public static final String NAME_DEFAULT = "Water";
    public static final String DESCRIPTION_DEFAULT = "2 part H, 1 part O";
    public static final double PRICE_SMALL_DEFAULT = 0.05;
    public static final double PRICE_MEDIUM_DEFAULT = 0.10;
    public static final double PRICE_LARGE_DEFAULT = 0.25;
    public static final boolean ICED_DEFAULT = true;

    public Water() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
