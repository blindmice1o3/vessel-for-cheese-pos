package com.jackingaming.vesselforcheesepos.models.menu.drinks.brewed;

public class Coffee extends Brewed {
    public static final String TAG = Coffee.class.getSimpleName();

    public static final String NAME_DEFAULT = "Coffee";
    public static final String DESCRIPTION_DEFAULT = "brewed with freshly grounded beans";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public Coffee() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
