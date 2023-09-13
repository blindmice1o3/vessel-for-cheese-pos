package com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class BlendedOptions extends DrinkComponent {
    public static final String TAG = BlendedOptions.class.getSimpleName();

    public BlendedOptions(String id) {
        super(id);
    }
}
