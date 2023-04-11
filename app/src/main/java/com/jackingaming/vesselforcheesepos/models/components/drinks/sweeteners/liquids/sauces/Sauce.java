package com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.sauces;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class Sauce extends DrinkComponent {
    public static final String TAG = "Sauce";

    public enum Type {
        CARAMEL_DRIZZLE,
        DARK_CARAMEL,
        MOCHA,
        WHITE_CHOCOLATE;
    }

    private Type type;

    public Sauce(Type type, boolean customization) {
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
