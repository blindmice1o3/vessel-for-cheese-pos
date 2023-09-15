package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Water;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.PullOptionsAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.Shots;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;

import java.util.ArrayList;
import java.util.List;

public class IcedEspresso extends IcedCoffees {
    public static final String TAG = IcedEspresso.class.getSimpleName();

    public static final String ID = "IcedEspresso";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Espresso";
    public static final String DEFAULT_DESCRIPTION = "Our smooth signature Espresso Roast over ice boasts rich, robust flavor and caramelly sweetness. A recipe of perfection at the heart of every handcrafted espresso we serve.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.DOPPIO;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SOLO, DrinkSize.DOPPIO, DrinkSize.TRIPLE, DrinkSize.QUAD};

    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS = RoastOptions.Type.SIGNATURE;
    public static final Shots.Type DEFAULT_SHOT = Shots.Type.SHOT;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN = 1;
    public static final PullOptionsAllowable.Type DEFAULT_PULL_OPTIONS = PullOptionsAllowable.Type.NONE;
    public static final PrepOptions.Type DEFAULT_PREP_OPTIONS = PrepOptions.Type.NONE;
    public static final Granular.Amount DEFAULT_WATER_AMOUNT = Granular.Amount.MEDIUM;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.TALL;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedEspresso() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        drinkSize = DEFAULT_DRINK_SIZE;
        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // ESPRESSO_OPTIONS
        RoastOptions roastOptions = new RoastOptions(DEFAULT_ROAST_OPTIONS);
        int numberOfShotByDrinkSize = getNumberOfShotByDrinkSize(drinkSize);
        Shots shots = new Shots(DEFAULT_SHOT, numberOfShotByDrinkSize);
        shots.setQuantityMin(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN);

        List<DrinkComponentWithDefaultAsString> espressoOptions = new ArrayList<>();
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                roastOptions, DEFAULT_ROAST_OPTIONS.name()
        ));

        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                shots, Integer.toString(numberOfShotByDrinkSize)
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new PullOptionsAllowable(null), DEFAULT_PULL_OPTIONS.name()
        ));
        espressoOptions.add(new DrinkComponentWithDefaultAsString(
                new PrepOptions(null), DEFAULT_PREP_OPTIONS.name()
        ));
        drinkComponentsStandardRecipe.add(roastOptions);
        drinkComponentsStandardRecipe.add(shots);

        drinkComponents.put(EspressoOptions.TAG, espressoOptions);

        // SWEETENER_OPTIONS (remove: Liquid)
        drinkComponents.get(SweetenerOptions.TAG).remove(0);

        DrinkComponent drinkComponentToRemove = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Liquid) {
                drinkComponentToRemove = drinkComponent;
            }
        }
        drinkComponentsStandardRecipe.remove(drinkComponentToRemove);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(5, new DrinkComponentWithDefaultAsString(
                new Water(null, DEFAULT_WATER_AMOUNT), DEFAULT_WATER_AMOUNT.name()
        ));

        // CUP_OPTIONS (remove: CupSize)
        drinkComponents.get(CupOptions.TAG).remove(0);

        drinkComponentToRemove = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof CupSize) {
                drinkComponentToRemove = drinkComponent;
            }
        }
        drinkComponentsStandardRecipe.remove(drinkComponentToRemove);

        // CUP_OPTIONS
        CupSize cupSize = new CupSize(DEFAULT_CUP_SIZE);

        List<DrinkComponentWithDefaultAsString> cupOptions = new ArrayList<>();
        cupOptions.add(new DrinkComponentWithDefaultAsString(
                cupSize, DEFAULT_CUP_SIZE.name()
        ));
        drinkComponentsStandardRecipe.add(cupSize);

        drinkComponents.put(CupOptions.TAG, cupOptions);
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SOLO:
                numberOfShotNew = 1;
                break;
            case DOPPIO:
                numberOfShotNew = 2;
                break;
            case TRIPLE:
                numberOfShotNew = 3;
                break;
            case QUAD:
                numberOfShotNew = 4;
                break;
            case SHORT:
            case TALL:
            case GRANDE:
            case VENTI_HOT:
            case VENTI_ICED:
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfShotNew;
    }
}
