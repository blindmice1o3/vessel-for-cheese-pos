package com.jackingaming.vesselforcheesepos.models.menu_items.foods;

import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;

public abstract class Food extends MenuItem {
    public static final String TAG = Food.class.getSimpleName();

    public Food() {
        super();
    }

    public Food(String id, int imageResourceId, String name, String description,
                int calories, int sugarInGram, float fatInGram,
                double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
