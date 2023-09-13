package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.straight_shots;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.Espresso;

public abstract class EspressoShots extends Espresso {
    public static final String TAG = EspressoShots.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.DOPPIO;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SOLO, DrinkSize.DOPPIO, DrinkSize.TRIPLE, DrinkSize.QUAD};

    public EspressoShots() {
    }

    public EspressoShots(String id, int imageResourceId, String name, String description,
                         int calories, int sugarInGram, float fatInGram,
                         double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSize = DEFAULT_DRINK_SIZE;
        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SOLO:
                numberOfShotNew = 1;
                break;
            case DOPPIO:
                numberOfShotNew = 2;
                break;
            case TRIPLE:
                numberOfShotNew = 3;
                break;
            case QUAD:
                numberOfShotNew = 4;
                break;
            case SHORT:
            case TALL:
            case GRANDE:
            case VENTI_HOT:
            case VENTI_ICED:
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfShotNew;
    }
}
