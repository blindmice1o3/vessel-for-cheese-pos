package com.jackingaming.vesselforcheesepos.models.menu.sides;

import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;

public abstract class Side extends MenuItem {
    public static final String TAG = "Side";

    public Side() {
        super();
    }

    public Side(String name, String description, double price) {
        super(name, description, price);
    }
}
