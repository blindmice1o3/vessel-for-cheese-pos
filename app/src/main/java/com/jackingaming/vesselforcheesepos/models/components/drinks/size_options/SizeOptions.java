package com.jackingaming.vesselforcheesepos.models.components.drinks.size_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class SizeOptions extends DrinkComponent {
    public static final String TAG = SizeOptions.class.getSimpleName();

    public enum DrinkSize {
        SHORT, TALL, GRANDE, VENTI, TRENTA;
    }

    private DrinkSize drinkSize;

    public SizeOptions(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    @NonNull
    @Override
    public String toString() {
        String nameSizeOptions = null;
        if (drinkSize != null) {
            nameSizeOptions = DrinkSize.class.getSimpleName() + ": " + drinkSize.name();
        } else {
            String errorMessage = SizeOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameSizeOptions = errorMessage;
        }
        return nameSizeOptions;
    }
}
