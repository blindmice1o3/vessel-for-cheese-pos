package com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class FlavorOptions extends DrinkComponent {
    public static final String TAG = FlavorOptions.class.getSimpleName();

    public FlavorOptions(String id) {
        super(id);
    }
}
