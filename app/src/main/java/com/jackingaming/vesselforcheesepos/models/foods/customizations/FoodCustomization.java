package com.jackingaming.vesselforcheesepos.models.foods.customizations;

import com.jackingaming.vesselforcheesepos.models.Customization;

public abstract class FoodCustomization extends Customization {
    public FoodCustomization() {
    }

    public FoodCustomization(String name, double price) {
        super(name, price);
    }
}
