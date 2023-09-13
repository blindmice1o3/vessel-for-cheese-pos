package com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class LemonadeOptions extends DrinkComponent {
    public static final String TAG = LemonadeOptions.class.getSimpleName();

    public LemonadeOptions(String id) {
        super(id);
    }
}
