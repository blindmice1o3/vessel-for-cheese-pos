package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public abstract class AddInsOptions extends DrinkComponent {
    public static final String TAG = AddInsOptions.class.getSimpleName();

    public AddInsOptions(String id) {
        super(id);
    }
}
