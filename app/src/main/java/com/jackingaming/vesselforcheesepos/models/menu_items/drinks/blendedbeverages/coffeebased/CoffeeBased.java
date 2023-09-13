package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.FrapRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.BlendedBeverages;

import java.util.List;

public abstract class CoffeeBased extends BlendedBeverages {
    public static final String TAG = CoffeeBased.class.getSimpleName();

    public static final FrapRoast.Type DEFAULT_FRAP_ROAST = FrapRoast.Type.FRAP_ROAST;

    public CoffeeBased() {
    }

    public CoffeeBased(String id, int imageResourceId, String name, String description,
                       int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);

        // BLENDED_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfFrapRoastByDrinkSize = getNumberOfFrapRoastByDrinkSize(drinkSize);
        FrapRoast frapRoast = new FrapRoast(DEFAULT_FRAP_ROAST, numberOfFrapRoastByDrinkSize);

        List<DrinkComponentWithDefaultAsString> blendedOptions = drinkComponents.get(BlendedOptions.TAG);
        blendedOptions.add(0, new DrinkComponentWithDefaultAsString(
                frapRoast, Integer.toString(numberOfFrapRoastByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(frapRoast);
    }
}
