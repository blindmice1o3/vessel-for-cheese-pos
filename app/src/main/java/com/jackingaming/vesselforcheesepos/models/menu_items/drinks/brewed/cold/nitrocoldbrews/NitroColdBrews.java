package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.nitrocoldbrews;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

import java.util.ArrayList;
import java.util.List;

public abstract class NitroColdBrews extends ColdBrewedCoffees {
    public static final String TAG = NitroColdBrews.class.getSimpleName();

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE};

    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.NO;

    public NitroColdBrews() {
    }

    public NitroColdBrews(String id, int imageResourceId, String name, String description,
                          int calories, int sugarInGram, float fatInGram,
                          double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
        Log.e(TAG, "NitroColdBrews()");

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // LEMONADE_OPTIONS (add into NEW DrinkComponent group)
        Lemonade lemonade = new Lemonade(null, DEFAULT_LEMONADE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                lemonade, DEFAULT_LEMONADE_AMOUNT.name()
        ));

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);

        // REMOVAL: ADD_INS_OPTIONS: Ice
        Ice ice = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Ice) {
                ice = (Ice) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(ice);
        drinkComponents.get(AddInsOptions.TAG).remove(0);
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
