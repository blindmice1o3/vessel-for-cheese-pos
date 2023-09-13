package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

public abstract class BrewedCoffees extends Drink {
    public static final String TAG = BrewedCoffees.class.getSimpleName();

    public BrewedCoffees() {
    }

    public BrewedCoffees(String id, int imageResourceId, String name, String description,
                         int calories, int sugarInGram, float fatInGram,
                         double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
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

        Log.i(TAG, "numberOfShotNew: " + numberOfShotNew);

        return numberOfShotNew;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfPumpNew = 2;
                break;
            case TALL:
                numberOfPumpNew = 3;
                break;
            case GRANDE:
                numberOfPumpNew = 4;
                break;
            case VENTI_HOT:
                numberOfPumpNew = 5;
                break;
            case VENTI_ICED:
                numberOfPumpNew = 6;
                break;
            case TRENTA:
                numberOfPumpNew = 7;
                break;
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        Log.i(TAG, "numberOfPumpNew: " + numberOfPumpNew);

        return numberOfPumpNew;
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfScoopNew = 1;
                break;
            case TALL:
                numberOfScoopNew = 2;
                break;
            case GRANDE:
                numberOfScoopNew = 3;
                break;
            case VENTI_HOT:
            case VENTI_ICED:
                numberOfScoopNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        Log.i(TAG, "numberOfScoopNew: " + numberOfScoopNew);

        return numberOfScoopNew;
    }

    @Override
    public int getNumberOfFrapRoastByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfFrapRoastByDrinkSize(DrinkSize)");

        int numberOfFrapRoastNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
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

        Log.i(TAG, "numberOfFrapRoastNew: " + numberOfFrapRoastNew);

        return numberOfFrapRoastNew;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        int numberOfTeaBagNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
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

        Log.i(TAG, "numberOfTeaBagNew: " + numberOfTeaBagNew);

        return numberOfTeaBagNew;
    }
}
