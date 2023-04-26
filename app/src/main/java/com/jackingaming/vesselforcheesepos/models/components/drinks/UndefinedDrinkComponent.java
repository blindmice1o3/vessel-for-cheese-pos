package com.jackingaming.vesselforcheesepos.models.components.drinks;

import androidx.annotation.NonNull;

public class UndefinedDrinkComponent extends DrinkComponent {
    public static final String TAG = UndefinedDrinkComponent.class.getSimpleName();

    public static final String NAME_DEFAULT = "Undefined";

    public UndefinedDrinkComponent() {
    }

    @NonNull
    @Override
    public String toString() {
        String nameUndefinedDrinkComponent = UndefinedDrinkComponent.class.getSimpleName();
        return nameUndefinedDrinkComponent;
    }
}
