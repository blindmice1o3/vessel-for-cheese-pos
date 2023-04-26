package com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class CupOptions extends DrinkComponent {
    public static final String TAG = CupOptions.class.getSimpleName();

    public enum CupSize {
        NONE, SHORT, TALL, GRANDE, VENTI, TRENTA;
    }

    private CupSize cupSize;

    public CupOptions(CupSize cupSize) {
        this.cupSize = cupSize;
    }

    public CupSize getCupSize() {
        return cupSize;
    }

    @NonNull
    @Override
    public String toString() {
        String nameCupOptions = null;
        if (cupSize != null) {
            nameCupOptions = CupSize.class.getSimpleName() + ": " + cupSize.name();
        } else {
            String errorMessage = CupOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameCupOptions = errorMessage;
        }
        return nameCupOptions;
    }
}
