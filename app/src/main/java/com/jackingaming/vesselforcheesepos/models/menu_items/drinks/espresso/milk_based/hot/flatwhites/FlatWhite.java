package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;

import java.util.List;

public class FlatWhite extends FlatWhites {
    public static final String TAG = FlatWhite.class.getSimpleName();

    public static final String ID = "FlatWhite";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Flat White";
    public static final String DEFAULT_DESCRIPTION = "Smooth ristretto shots of espresso get the perfect amount of steamed whole milk to create a not-too-strong, not-too-creamy, just-right flavor.";
    public static final int DEFAULT_CALORIES = 170;
    public static final int DEFAULT_SUGAR_IN_GRAM = 13;
    public static final float DEFAULT_FAT_IN_GRAM = 9.0f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_WHOLE_MILK = MilkBase.Type.WHOLE_MILK;
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS_RISTRETTO = PullOptions.Type.RISTRETTO;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;

    public FlatWhite() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_WHOLE_MILK);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_WHOLE_MILK.name());

        // REMOVAL: ESPRESSO_OPTIONS: PullOptionsAllowable
        PullOptionsAllowable pullOptionsAllowable = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof PullOptionsAllowable) {
                pullOptionsAllowable = (PullOptionsAllowable) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(pullOptionsAllowable);
        drinkComponents.get(EspressoOptions.TAG).remove(2);

        // ESPRESSO_OPTIONS: PullOptions (add into EXISTING DrinkComponent group)
        PullOptions pullOptions = new PullOptions(DEFAULT_PULL_OPTIONS_RISTRETTO);
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                pullOptions, DEFAULT_PULL_OPTIONS_RISTRETTO.name()
        ));

        drinkComponentsStandardRecipe.add(pullOptions);
    }
}
