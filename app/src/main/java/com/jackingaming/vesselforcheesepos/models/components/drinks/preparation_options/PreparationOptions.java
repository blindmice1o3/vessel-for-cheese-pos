package com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class PreparationOptions extends DrinkComponent {
    public static final String TAG = PreparationMethod.class.getSimpleName();

    public enum PreparationMethod {
        NONE,
        BLENDED;
    }
}
