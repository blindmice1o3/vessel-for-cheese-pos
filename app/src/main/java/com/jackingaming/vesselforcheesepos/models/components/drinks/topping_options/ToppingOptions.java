package com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class ToppingOptions extends DrinkComponent {
    public static final String TAG = ToppingOptions.class.getSimpleName();

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum CinnamonPowder {
        CINNAMON_POWDER;
    }

    public enum ColdFoam {
        CHOCOLATE_CREAM,
        PISTACHIO_CREAM,
        SALTED_CARAMEL_CREAM,
        VANILLA_SWEET_CREAM;
    }

    public enum Drizzle {
        CARAMEL,
        MOCHA;
    }

    public enum Topping {
        CINNAMON_DOLCE_SPRINKLES,
        COOKIE_CRUMBLE,
        SALTED_BROWN_BUTTER;
    }

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum WhippedCream {
        WHIPPED_CREAM;
    }

    private CinnamonPowder cinnamonPowder;
    private ColdFoam coldFoam;
    private Drizzle drizzle;
    private Topping topping;
    private WhippedCream whippedCream;

    public ToppingOptions(CinnamonPowder cinnamonPowder) {
        this.cinnamonPowder = cinnamonPowder;
    }

    public ToppingOptions(ColdFoam coldFoam) {
        this.coldFoam = coldFoam;
    }

    public ToppingOptions(Drizzle drizzle) {
        this.drizzle = drizzle;
    }

    public ToppingOptions(Topping topping) {
        this.topping = topping;
    }

    public ToppingOptions(WhippedCream whippedCream) {
        this.whippedCream = whippedCream;
    }

    public CinnamonPowder getCinnamonPowder() {
        return cinnamonPowder;
    }

    public ColdFoam getColdFoam() {
        return coldFoam;
    }

    public Drizzle getDrizzle() {
        return drizzle;
    }

    public Topping getTopping() {
        return topping;
    }

    public WhippedCream getWhippedCream() {
        return whippedCream;
    }

    @NonNull
    @Override
    public String toString() {
        String nameToppingOptions = null;
        if (cinnamonPowder != null) {
            nameToppingOptions = CinnamonPowder.class.getSimpleName() + ": " + cinnamonPowder.name();
        } else if (coldFoam != null) {
            nameToppingOptions = ColdFoam.class.getSimpleName() + ": " + coldFoam.name();
        } else if (drizzle != null) {
            nameToppingOptions = Drizzle.class.getSimpleName() + ": " + drizzle.name();
        } else if (topping != null) {
            nameToppingOptions = Topping.class.getSimpleName() + ": " + topping.name();
        } else if (whippedCream != null) {
            nameToppingOptions = WhippedCream.class.getSimpleName() + ": " + whippedCream.name();
        } else {
            String errorMessage = ToppingOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameToppingOptions = errorMessage;
        }
        return nameToppingOptions;
    }
}
