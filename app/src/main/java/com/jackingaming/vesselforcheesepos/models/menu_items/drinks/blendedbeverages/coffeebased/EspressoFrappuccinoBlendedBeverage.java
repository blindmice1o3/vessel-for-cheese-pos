package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;

import java.util.List;

public class EspressoFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = EspressoFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String ID = "EspressoFrappuccinoBlendedBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Espresso Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Coffee is combined with a shot of espresso and milk, then blended with ice to give you a nice little jolt and lots of sipping joy.";
    public static final int DEFAULT_CALORIES = 210;
    public static final int DEFAULT_SUGAR_IN_GRAM = 42;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final Shots.Type DEFAULT_SHOT = Shots.Type.SHOT;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN = 1;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public EspressoFrappuccinoBlendedBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: ESPRESSO_OPTIONS: Shots
        drinkComponents.get(EspressoOptions.TAG).remove(2);

        // ESPRESSO_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfShotByDrinkSize = getNumberOfShotByDrinkSize(drinkSize);
        Shots shots = new Shots(DEFAULT_SHOT, numberOfShotByDrinkSize);
        shots.setQuantityMin(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN);

        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(0, new DrinkComponentWithDefaultAsString(
                shots, Integer.toString(numberOfShotByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(shots);
    }
}
