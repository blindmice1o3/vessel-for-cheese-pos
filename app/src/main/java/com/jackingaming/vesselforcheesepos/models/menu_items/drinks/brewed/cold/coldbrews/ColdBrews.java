package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

import java.util.ArrayList;
import java.util.List;

public abstract class ColdBrews extends ColdBrewedCoffees {
    public static final String TAG = ColdBrews.class.getSimpleName();

    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.NO;
    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;

    public ColdBrews() {
    }

    public ColdBrews(String id, int imageResourceId, String name, String description,
                     int calories, int sugarInGram, float fatInGram,
                     double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);

        // LEMONADE_OPTIONS (add into NEW DrinkComponent group)
        Lemonade lemonade = new Lemonade(null, DEFAULT_LEMONADE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                lemonade, DEFAULT_LEMONADE_AMOUNT.name()
        ));
        // PREPARATION_OPTIONS (add into NEW DrinkComponent group)
        PreparationMethod preparationMethod = new PreparationMethod(DEFAULT_PREPARATION_METHOD);

        List<DrinkComponentWithDefaultAsString> preparationOptions = new ArrayList<>();
        preparationOptions.add(new DrinkComponentWithDefaultAsString(
                preparationMethod, DEFAULT_PREPARATION_METHOD.name()
        ));

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);
        drinkComponents.put(PreparationOptions.TAG, preparationOptions);
        drinkComponentsStandardRecipe.add(preparationMethod);
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                break;
            case TALL:
                numberOfPumpNew = 1;
                break;
            case GRANDE:
                numberOfPumpNew = 2;
                break;
            case VENTI_HOT:
                break;
            case VENTI_ICED:
                numberOfPumpNew = 3;
                break;
            case TRENTA:
                numberOfPumpNew = 4;
                break;
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        Log.i(TAG, "numberOfPumpNew: " + numberOfPumpNew);

        return numberOfPumpNew;
    }
}
