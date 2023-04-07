package com.jackingaming.vesselforcheesepos.models.drinks;

import com.jackingaming.vesselforcheesepos.models.MenuItem;
import com.jackingaming.vesselforcheesepos.models.drinks.customizations.DrinkCustomization;

import java.util.ArrayList;
import java.util.List;

public abstract class Drink extends MenuItem {
    protected List<DrinkCustomization> customizations = new ArrayList<DrinkCustomization>();

    public Drink() {
        super();
    }

    public Drink(String name, String description, double price, boolean handedOff) {
        super(name, description, price, handedOff);
    }

    public List<DrinkCustomization> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<DrinkCustomization> customizations) {
        this.customizations = customizations;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "customizations=" + customizations +
                '}';
    }
}
