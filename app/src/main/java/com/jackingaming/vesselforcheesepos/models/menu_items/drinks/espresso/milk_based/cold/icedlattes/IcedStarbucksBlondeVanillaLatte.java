package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;

import java.util.List;

public class IcedStarbucksBlondeVanillaLatte extends IcedLattes {
    public static final String TAG = IcedStarbucksBlondeVanillaLatte.class.getSimpleName();

    public static final String ID = "IcedStarbucksBlondeVanillaLatte";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Starbucks Blonde Vanilla Latte";
    public static final String DEFAULT_DESCRIPTION = "Seriously smooth and subtly sweet Starbucks Blonde Espresso, milk, ice and vanilla syrup come together to create a delightful twist on a beloved espresso classic.";
    public static final int DEFAULT_CALORIES = 190;
    public static final int DEFAULT_SUGAR_IN_GRAM = 28;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS_BLONDE = RoastOptions.Type.BLONDE;
    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA_SYRUP;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedStarbucksBlondeVanillaLatte() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupVanilla = new Syrup(DEFAULT_SYRUP_VANILLA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupVanilla, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(syrupVanilla);

        // ESPRESSO_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        RoastOptions roastOptionsBlonde = (RoastOptions) espressoOptions.get(0).getDrinkComponent();
        roastOptionsBlonde.setType(DEFAULT_ROAST_OPTIONS_BLONDE);
        espressoOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_ROAST_OPTIONS_BLONDE.name());

        // REMOVAL: CUP_OPTIONS
        CupSize cupSize = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof CupSize) {
                cupSize = (CupSize) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(cupSize);
        drinkComponents.remove(CupOptions.TAG);
    }
}
