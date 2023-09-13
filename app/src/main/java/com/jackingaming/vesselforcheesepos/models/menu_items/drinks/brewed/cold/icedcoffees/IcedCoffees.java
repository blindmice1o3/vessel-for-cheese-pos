package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

import java.util.List;

public abstract class IcedCoffees extends ColdBrewedCoffees {
    public static final String TAG = IcedCoffees.class.getSimpleName();

    public static final Liquid.Type DEFAULT_LIQUID_CLASSIC = Liquid.Type.CLASSIC;

    public IcedCoffees() {
    }

    public IcedCoffees(String id, int imageResourceId, String name, String description,
                       int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);

        // SWEETENER_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquidClassic = new Liquid(DEFAULT_LIQUID_CLASSIC, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquidClassic, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(liquidClassic);
    }
}
