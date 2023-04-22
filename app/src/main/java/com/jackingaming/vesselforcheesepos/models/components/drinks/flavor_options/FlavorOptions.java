package com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.views.viewport.CustomizedDrinkComponentAdapter;

public class FlavorOptions extends DrinkComponent {
    public static final String TAG = FlavorOptions.class.getSimpleName();

    public enum Sauce {
        DARK_CARAMEL,
        MOCHA,
        PISTACHIO,
        WHITE_CHOCOLATE_MOCHA;
    }

    public enum Syrup {
        BROWN_SUGAR,
        CARAMEL,
        CINNAMON_DOLCE,
        HAZELNUT,
        PEPPERMINT,
        RASPBERRY,
        SUGAR_FREE_VANILLA,
        TOASTED_VANILLA,
        TOFFEE_NUT,
        VANILLA;
    }

    private Sauce sauce;
    private Syrup syrup;

    public FlavorOptions(Sauce sauce) {
        this.sauce = sauce;
    }

    public FlavorOptions(Syrup syrup) {
        this.syrup = syrup;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Syrup getSyrup() {
        return syrup;
    }

    @NonNull
    @Override
    public String toString() {
        String nameFlavorOptions = null;
        if (syrup != null) {
            nameFlavorOptions = Syrup.class.getSimpleName() + ": " + syrup.name();
        } else if (sauce != null) {
            nameFlavorOptions = Sauce.class.getSimpleName() + ": " + sauce.name();
        } else {
            String errorMessage = FlavorOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameFlavorOptions = errorMessage;
        }
        return nameFlavorOptions;
    }
}
