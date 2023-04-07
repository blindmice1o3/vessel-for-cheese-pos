package com.jackingaming.vesselforcheesepos.models.foods;

import com.jackingaming.vesselforcheesepos.models.MenuItem;
import com.jackingaming.vesselforcheesepos.models.foods.customizations.FoodCustomization;

import java.util.ArrayList;
import java.util.List;

public abstract class Food extends MenuItem {
    protected List<FoodCustomization> customizations = new ArrayList<FoodCustomization>();

    public Food() {
        super();
    }

    public Food(String name, String description, double price, boolean handedOff) {
        super(name, description, price, handedOff);
    }

    public List<FoodCustomization> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<FoodCustomization> customizations) {
        this.customizations = customizations;
    }

    @Override
    public String toString() {
        return "Food{" +
                "customizations=" + customizations +
                '}';
    }
}
