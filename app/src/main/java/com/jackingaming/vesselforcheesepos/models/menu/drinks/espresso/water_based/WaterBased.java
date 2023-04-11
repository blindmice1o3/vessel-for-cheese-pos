package com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.water_based;

import com.jackingaming.vesselforcheesepos.models.menu.drinks.espresso.Espresso;

public abstract class WaterBased extends Espresso {
    public WaterBased() {
    }

    public WaterBased(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
