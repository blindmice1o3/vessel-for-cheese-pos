package com.jackingaming.vesselforcheesepos.models.menu.foods;

public class Bread extends Food {
    public static final String TAG = Bread.class.getSimpleName();

    public static final String NAME_DEFAULT = "Bread";
    public static final String DESCRIPTION_DEFAULT = "made from multiplying yeast";
    public static final double PRICE_DEFAULT = 0.10;

    public Bread() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT);
    }
}
