package com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class JuiceOptions extends DrinkComponent {
    public static final String TAG = JuiceOptions.class.getSimpleName();

    public JuiceOptions(String id) {
        super(id);
    }
}
