package com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class LemonadeOptions extends DrinkComponent {
    public static final String TAG = Lemonade.class.getSimpleName();

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum Lemonade {
        LEMONADE;
    }

    private Lemonade lemonade;

    public LemonadeOptions(Lemonade lemonade) {
        this.lemonade = lemonade;
    }

    public Lemonade getLemonade() {
        return lemonade;
    }
}
