package com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class TeaOptions extends DrinkComponent {
    public static final String TAG = TeaOptions.class.getSimpleName();

    public TeaOptions(String id) {
        super(id);
    }
}
