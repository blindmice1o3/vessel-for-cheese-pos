package com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class JuiceOptions extends DrinkComponent {
    public static final String TAG = JuiceOptions.class.getSimpleName();

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum Juice {
        APPLE,
        PEACH_BLEND;
    }

    private Juice juice;

    public JuiceOptions(Juice juice) {
        this.juice = juice;
    }

    public Juice getJuice() {
        return juice;
    }
}
