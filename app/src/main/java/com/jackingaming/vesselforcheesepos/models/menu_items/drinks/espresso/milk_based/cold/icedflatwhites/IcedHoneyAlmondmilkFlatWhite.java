package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites;

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
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.List;

public class IcedHoneyAlmondmilkFlatWhite extends IcedFlatWhites {
    public static final String TAG = IcedHoneyAlmondmilkFlatWhite.class.getSimpleName();

    public static final String ID = "IcedHoneyAlmondmilkFlatWhite";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Honey Almondmilk Flat White";
    public static final String DEFAULT_DESCRIPTION = "This iced flat white--intentionally made with almondmilk and Starbucks Blonde Espresso Roast poured over ice with a hint of honey--creates a perfect amount of cool, creamy, nutty sweetness.";
    public static final int DEFAULT_CALORIES = 100;
    public static final int DEFAULT_SUGAR_IN_GRAM = 17;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final MilkBase.Type DEFAULT_MILK_BASE_ALMOND = MilkBase.Type.ALMOND;
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS_RISTRETTO = PullOptions.Type.RISTRETTO;
    public static final RoastOptionsAllowable.Type DEFAULT_ROAST_OPTIONS_ALLOWABLE = RoastOptionsAllowable.Type.NONE;
    public static final Liquid.Type DEFAULT_LIQUID_HONEY_BLEND = Liquid.Type.HONEY_BLEND;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedHoneyAlmondmilkFlatWhite() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        this.drinkSize = DrinkSize.TALL;

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_ALMOND);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_ALMOND.name());

        // REMOVAL: ESPRESSO_OPTIONS: Shots
        Shots shots = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Shots) {
                shots = (Shots) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(shots);
        drinkComponents.get(EspressoOptions.TAG).remove(1);

        // ESPRESSO_OPTIONS: Shots (add into EXISTING DrinkComponent group)
        int numberOfShotByDrinkSize = getNumberOfShotByDrinkSize(drinkSize);
        Shots shotsTall = new Shots(DEFAULT_SHOT, numberOfShotByDrinkSize);
        shotsTall.setQuantityMin(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN);
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                shotsTall, Integer.toString(numberOfShotByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(shotsTall);

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
        espressoOptions.add(1, new DrinkComponentWithDefaultAsString(
                pullOptions, DEFAULT_PULL_OPTIONS_RISTRETTO.name()
        ));

        drinkComponentsStandardRecipe.add(pullOptions);

        // REMOVAL: ESPRESSO_OPTIONS: RoastOptions (replace with RoastOptionsAllowable)
        RoastOptions roastOptions = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof RoastOptions) {
                roastOptions = (RoastOptions) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(roastOptions);
        drinkComponents.get(EspressoOptions.TAG).remove(0);

        // ESPRESSO_OPTIONS (add into EXISTING DrinkComponent group)
        RoastOptionsAllowable roastOptionsAllowable = new RoastOptionsAllowable(null);

        espressoOptions.add(2, new DrinkComponentWithDefaultAsString(
                roastOptionsAllowable, DEFAULT_ROAST_OPTIONS_ALLOWABLE.name()
        ));

        // SWEETENER_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Liquid liquidHoneyBlend = new Liquid(DEFAULT_LIQUID_HONEY_BLEND, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> sweetenerOptions = drinkComponents.get(SweetenerOptions.TAG);
        sweetenerOptions.add(0, new DrinkComponentWithDefaultAsString(
                liquidHoneyBlend, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(liquidHoneyBlend);

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
