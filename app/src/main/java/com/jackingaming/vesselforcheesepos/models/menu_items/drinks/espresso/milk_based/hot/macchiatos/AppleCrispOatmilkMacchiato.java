package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class AppleCrispOatmilkMacchiato extends Macchiatos {
    public static final String TAG = AppleCrispOatmilkMacchiato.class.getSimpleName();

    public static final String ID = "AppleCrispOatmilkMacchiato";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Apple Crisp Oatmilk Macchiato";
    public static final String DEFAULT_DESCRIPTION = "Layered flavors of apple, cinnamon, oats and brown sugar harmonize with Starbucks Blonde Espresso Roast, creamy oatmilk and spiced-apple drizzle to create a delicious apple crisp you can sip. A nostalgic autumn pick-me-up.";
    public static final int DEFAULT_CALORIES = 320;
    public static final int DEFAULT_SUGAR_IN_GRAM = 29;
    public static final float DEFAULT_FAT_IN_GRAM = 10.0f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_OATMILK = MilkBase.Type.OATMILK;
    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS_BLONDE = RoastOptions.Type.BLONDE;
    public static final Syrup.Type DEFAULT_SYRUP_APPLE_BROWN_SUGAR = Syrup.Type.APPLE_BROWN_SUGAR;
    public static final Drizzle.Type DEFAULT_DRIZZLE_SPICED_APPLE = Drizzle.Type.SPICED_APPLE_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public AppleCrispOatmilkMacchiato() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_OATMILK);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_OATMILK.name());

        // ESPRESSO_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        RoastOptions roastOptionsBlonde = (RoastOptions) espressoOptions.get(0).getDrinkComponent();
        roastOptionsBlonde.setType(DEFAULT_ROAST_OPTIONS_BLONDE);
        espressoOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_ROAST_OPTIONS_BLONDE.name());

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupAppleBrownSugar = new Syrup(DEFAULT_SYRUP_APPLE_BROWN_SUGAR, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupAppleBrownSugar, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(syrupAppleBrownSugar);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Drizzle drizzleSpicedApple = new Drizzle(DEFAULT_DRIZZLE_SPICED_APPLE, DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleSpicedApple, DEFAULT_DRIZZLE_SPICED_APPLE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleSpicedApple);
    }
}
