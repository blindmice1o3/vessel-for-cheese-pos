package com.jackingaming.vesselforcheesepos.models.menu.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Drink extends MenuItem {
    public static final String TAG = Drink.class.getSimpleName();

    public static final Size SIZE_DEFAULT = Size.MEDIUM;

    public enum Size {SMALL, MEDIUM, LARGE;}

    protected Size size;
    protected boolean iced;
    protected List<DrinkComponent> customizedDrinkComponents = new ArrayList<>();

    public Drink() {
        super();
    }

    public Drink(String name, String description, double price, boolean iced) {
        super(name, description, price);
        this.size = SIZE_DEFAULT;
        this.iced = iced;
    }

    public void addDrinkComponent(DrinkComponent drinkComponent) {
        Log.i(TAG, "addDrinkComponent(DrinkComponent)");
        customizedDrinkComponents.add(drinkComponent);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isIced() {
        return iced;
    }

    public void setIced(boolean iced) {
        this.iced = iced;
    }

    public List<DrinkComponent> getCustomizedDrinkComponents() {
        return customizedDrinkComponents;
    }

    public void setCustomizedDrinkComponents(List<DrinkComponent> customizedDrinkComponents) {
        this.customizedDrinkComponents = customizedDrinkComponents;
    }
}
