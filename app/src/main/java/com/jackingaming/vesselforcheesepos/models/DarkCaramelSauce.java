package com.jackingaming.vesselforcheesepos.models;

public class DarkCaramelSauce extends MenuItem {
    public static final String NAME_DEFAULT = "dark caramel sauce";
    public static final String DESCRIPTION_DEFAULT = "a more buttery version of caramel";
    public static final double PRICE_DEFAULT = 0.25;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public DarkCaramelSauce() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
