package com.jackingaming.vesselforcheesepos.models.components.drinks.milks;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class Milk extends DrinkComponent {
    public static final String TAG = "Milk";

    public enum Type {
        TWO_PERCENT,
        BREVE,
        COCONUT,
        HEAVY_CREAM,
        NONFAT_MILK,
        OATMILK,
        SOY,
        VANILLA_SWEET_CREAM,
        WHOLE_MILK,
        ALMOND;
    }

    private Type type;

    public Milk(Type type, boolean customization) {
        super(customization);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
