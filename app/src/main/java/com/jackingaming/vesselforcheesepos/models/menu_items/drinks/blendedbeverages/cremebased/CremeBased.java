package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.BlendedBeverages;

public abstract class CremeBased extends BlendedBeverages {
    public static final String TAG = CremeBased.class.getSimpleName();

    public CremeBased() {
    }

    public CremeBased(String id, int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
