package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;

import java.util.List;

public class IcedFlatWhite extends IcedFlatWhites {
    public static final String TAG = IcedFlatWhite.class.getSimpleName();

    public static final String ID = "IcedFlatWhite";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Flat White";
    public static final String DEFAULT_DESCRIPTION = "Smooth ristretto shots of espresso get the perfect amount of whole milk and ice to create a not-too-strong, not-too-creamy, just-right flavor.";
    public static final int DEFAULT_CALORIES = 150;
    public static final int DEFAULT_SUGAR_IN_GRAM = 11;
    public static final float DEFAULT_FAT_IN_GRAM = 8.0f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_WHOLE_MILK = MilkBase.Type.WHOLE_MILK;
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS_RISTRETTO = PullOptions.Type.RISTRETTO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedFlatWhite() {
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
