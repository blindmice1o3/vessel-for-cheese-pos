package com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class PreparationOptions extends DrinkComponent {
    public static final String TAG = PreparationOptions.class.getSimpleName();

    public PreparationOptions(String id) {
        super(id);
    }
}
