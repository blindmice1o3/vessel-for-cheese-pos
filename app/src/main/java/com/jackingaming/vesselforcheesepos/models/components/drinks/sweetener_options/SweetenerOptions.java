package com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class SweetenerOptions extends DrinkComponent {
    public static final String TAG = SweetenerOptions.class.getSimpleName();

    public SweetenerOptions(String id) {
        super(id);
    }
}
