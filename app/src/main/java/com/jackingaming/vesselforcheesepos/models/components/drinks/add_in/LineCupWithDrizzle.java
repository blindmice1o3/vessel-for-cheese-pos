package com.jackingaming.vesselforcheesepos.models.components.drinks.add_in;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.sauces.Sauce;

public class LineCupWithDrizzle extends DrinkComponent {
    public static final String TAG = "LineCupWithDrizzle";

    private Sauce.Type sauceType;

    public LineCupWithDrizzle(Sauce.Type sauceType, boolean customization) {
        super(customization);
        this.sauceType = sauceType;
    }

    public Sauce.Type getSauceType() {
        return sauceType;
    }

    public void setSauceType(Sauce.Type sauceType) {
        this.sauceType = sauceType;
    }
}
