package com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class ToppingOptions extends DrinkComponent {
    public static final String TAG = ToppingOptions.class.getSimpleName();

    public ToppingOptions(String id) {
        super(id);
    }
}
