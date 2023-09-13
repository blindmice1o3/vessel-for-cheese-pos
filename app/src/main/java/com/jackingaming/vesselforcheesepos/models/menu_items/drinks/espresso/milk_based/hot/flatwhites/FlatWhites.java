package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites;

import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.HotMilkBased;

public abstract class FlatWhites extends HotMilkBased {
    public static final String TAG = FlatWhites.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.TALL;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public FlatWhites() {
    }

    public FlatWhites(String id, int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
