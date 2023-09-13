package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;

import java.util.List;

public class HoneyAlmondmilkFlatWhite extends FlatWhites {
    public static final String TAG = HoneyAlmondmilkFlatWhite.class.getSimpleName();

    public static final String ID = "HoneyAlmondmilkFlatWhite";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Honey Almondmilk Flat White";
    public static final String DEFAULT_DESCRIPTION = "This flat white intentionally pairs almondmilk and Starbucks Blonde Espresso Roast with a hint of honey, making a perfect amount of creamy, nutty sweetness.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_ALMOND = MilkBase.Type.ALMOND;
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS_RISTRETTO = PullOptions.Type.RISTRETTO;
    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final Liquid.Type DEFAULT_LIQUID_HONEY_BLEND = Liquid.Type.HONEY_BLEND;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;

    public HoneyAlmondmilkFlatWhite() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_ALMOND);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_ALMOND.name());

        // TODO: FlatWhite and HoneyAlmondFlatWhite have broken RoastOptions/RoastOptionsAllowable
        // TODO: remove PullOptionsAllowable and replace with PullOptions
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

        // REMOVAL: ESPRESSO_OPTIONS: RoastOptions
        RoastOptions roastOptions = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof RoastOptions) {
                roastOptions = (RoastOptions) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(roastOptions);
        drinkComponents.get(EspressoOptions.TAG).remove(0);

        // ESPRESSO_OPTIONS: PullOptions (add into EXISTING DrinkComponent group)
        // ESPRESSO_OPTIONS: RoastOptionsAllowable (add into EXISTING DrinkComponent group)
        PullOptions pullOptions = new PullOptions(DEFAULT_PULL_OPTIONS_RISTRETTO);

        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(0, new DrinkComponentWithDefaultAsString(
                pullOptions, DEFAULT_PULL_OPTIONS_RISTRETTO.name()
        ));
        espressoOptions.add(2, new DrinkComponentWithDefaultAsString(
                new RoastOptionsAllowable(null), DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));

        drinkComponentsStandardRecipe.add(pullOptions);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquid = new Liquid(DEFAULT_LIQUID_HONEY_BLEND, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquid, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(liquid);

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
