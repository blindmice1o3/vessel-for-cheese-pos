package com.jackingaming.vesselforcheesepos.models.sides;

public class SteamedVegetable extends Side {
    public static final String NAME_DEFAULT = "steamed vegetable";
    public static final String DESCRIPTION_DEFAULT = "mixed bag of primary producers";
    public static final double PRICE_DEFAULT = 0.05;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public SteamedVegetable() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
