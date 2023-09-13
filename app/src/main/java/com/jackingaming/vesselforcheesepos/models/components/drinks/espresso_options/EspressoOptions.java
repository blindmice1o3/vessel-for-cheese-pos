package com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class EspressoOptions extends DrinkComponent {
    public static final String TAG = EspressoOptions.class.getSimpleName();

    public EspressoOptions(String id) {
        super(id);
    }
}
