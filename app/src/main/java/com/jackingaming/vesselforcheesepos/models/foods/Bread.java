package com.jackingaming.vesselforcheesepos.models.foods;

public class Bread extends Food {
    public static final String NAME_DEFAULT = "bread";
    public static final String DESCRIPTION_DEFAULT = "made from multiplying yeast";
    public static final double PRICE_DEFAULT = 0.10;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public Bread() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
