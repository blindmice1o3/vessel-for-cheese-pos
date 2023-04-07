package com.jackingaming.vesselforcheesepos.models.drinks.customizations.add_in;

import com.jackingaming.vesselforcheesepos.models.drinks.customizations.DrinkCustomization;

public class LineCupWithMocha extends DrinkCustomization {
    public static final String NAME_DEFAULT = "line cup with mocha";
    public static final double PRICE_DEFAULT = 0.60;

    public LineCupWithMocha() {
        super(NAME_DEFAULT, PRICE_DEFAULT);
    }
}
