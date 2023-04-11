package com.jackingaming.vesselforcheesepos.models.menu.sides;

public class SteamedVegetable extends Side {
    public static final String TAG = "SteamedVegetable";

    public static final String NAME_DEFAULT = "Steamed vegetable";
    public static final String DESCRIPTION_DEFAULT = "mixed bag of primary producers";
    public static final double PRICE_DEFAULT = 0.05;

    public SteamedVegetable() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT);
    }
}
