package com.jackingaming.vesselforcheesepos.models.drinks.customizations;

import com.jackingaming.vesselforcheesepos.models.Customization;

public abstract class DrinkCustomization extends Customization {
    public DrinkCustomization() {
        super();
    }

    public DrinkCustomization(String name, double price) {
        super(name, price);
    }
}
