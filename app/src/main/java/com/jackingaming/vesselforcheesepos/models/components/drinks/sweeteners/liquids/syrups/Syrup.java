package com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.syrups;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class Syrup extends DrinkComponent {
    public static final String TAG = "Syrup";

    public enum Type {
        CARAMEL,
        TOFFEE_NUT,
        VANILLA;
    }

    private Type type;

    public Syrup(Type type, boolean customization) {
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
