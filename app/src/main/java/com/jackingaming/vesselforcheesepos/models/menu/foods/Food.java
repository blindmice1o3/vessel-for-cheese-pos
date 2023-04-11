package com.jackingaming.vesselforcheesepos.models.menu.foods;

import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;

public abstract class Food extends MenuItem {
    public static final String TAG = "Food";

    public Food() {
        super();
    }

    public Food(String name, String description, double price) {
        super(name, description, price);
    }
}
