package com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.views.viewport.CustomizedDrinkComponentAdapter;

public class LemonadeOptions extends DrinkComponent {
    public static final String TAG = Lemonade.class.getSimpleName();

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum Lemonade {
        LEMONADE;
    }

    private Lemonade lemonade;

    public LemonadeOptions(Lemonade lemonade) {
        this.lemonade = lemonade;
    }

    public Lemonade getLemonade() {
        return lemonade;
    }

    @NonNull
    @Override
    public String toString() {
        String nameLemonadeOptions = null;
        if (lemonade != null) {
            nameLemonadeOptions = Lemonade.class.getSimpleName() + ": " + lemonade.name();
        } else {
            String errorMessage = LemonadeOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameLemonadeOptions = errorMessage;
        }
        return nameLemonadeOptions;
    }
}
