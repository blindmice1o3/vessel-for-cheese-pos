package com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class MilkOptions extends DrinkComponent {
    public static final String TAG = MilkOptions.class.getSimpleName();

    public MilkOptions(String id) {
        super(id);
    }
}
