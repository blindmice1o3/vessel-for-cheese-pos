package com.jackingaming.vesselforcheesepos.models.menu;

public class UndefinedMenuItem extends MenuItem {
    public static final String TAG = "UndefinedMenuItem";

    public static final String NAME_DEFAULT = "Undefined";
    public static final String DESCRIPTION_DEFAULT = "no description";
    public static final double PRICE_DEFAULT = 0.00;

    public UndefinedMenuItem() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT);
    }
}
