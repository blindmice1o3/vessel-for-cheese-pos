package com.jackingaming.vesselforcheesepos.models;

public class Undefined extends MenuItem {
    public static final String NAME_DEFAULT = "undefined";
    public static final String DESCRIPTION_DEFAULT = "no description";
    public static final double PRICE_DEFAULT = 0.00;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public Undefined() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
