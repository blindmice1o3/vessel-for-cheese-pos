package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.powders.derived.ChocolateMaltPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;

import java.util.ArrayList;
import java.util.List;

public class IcedChocolateAlmondmilkShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedChocolateAlmondmilkShakenEspresso.class.getSimpleName();

    public static final String ID = "IcedChocolateAlmondmilkShakenEspresso";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Chocolate Almondmilk Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Blonde espresso meets cocoa and notes of malt, shaken together and topped with almondmilk and ice for an invigorating treat to power you through your day.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 16;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final MilkBase.Type DEFAULT_MILK_BASE_ALMOND = MilkBase.Type.ALMOND;
    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS_BLONDE = RoastOptions.Type.BLONDE;
    public static final ChocolateMaltPowder.Type DEFAULT_POWDERS_CHOCOLATE_MALT = ChocolateMaltPowder.Type.CHOCOLATE_MALT_POWDER;
    public static final Granular.Amount DEFAULT_POWDERS_CHOCOLATE_MALT_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedChocolateAlmondmilkShakenEspresso() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // PREPARATION_OPTIONS (add into NEW DrinkComponent group)
        PreparationMethod preparationMethod = new PreparationMethod(DEFAULT_PREPARATION_METHOD);

        List<DrinkComponentWithDefaultAsString> preparationOptions = new ArrayList<>();
        preparationOptions.add(new DrinkComponentWithDefaultAsString(
                preparationMethod, DEFAULT_PREPARATION_METHOD.name()
        ));
        drinkComponentsStandardRecipe.add(preparationMethod);

        drinkComponents.put(PreparationOptions.TAG, preparationOptions);

        // MILK_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> milkOptions = drinkComponents.get(MilkOptions.TAG);
        MilkBase milkBase = (MilkBase) milkOptions.get(0).getDrinkComponent();
        milkBase.setType(DEFAULT_MILK_BASE_ALMOND);
        milkOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_MILK_BASE_ALMOND.name());

        // ESPRESSO_OPTIONS (update EXISTING DrinkComponent)
        List<DrinkComponentWithDefaultAsString> espressoOptions = drinkComponents.get(EspressoOptions.TAG);
        RoastOptions roastOptionsBlonde = (RoastOptions) espressoOptions.get(0).getDrinkComponent();
        roastOptionsBlonde.setType(DEFAULT_ROAST_OPTIONS_BLONDE);
        espressoOptions.get(0).setDrinkComponentDefaultAsString(DEFAULT_ROAST_OPTIONS_BLONDE.name());

        // REMOVAL: ADD_INS_OPTIONS: Powder
        drinkComponents.get(AddInsOptions.TAG).remove(2);

        // REMOVAL: ADD_INS_OPTIONS: Ice
        Ice ice = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Ice) {
                ice = (Ice) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(ice);
        drinkComponents.get(AddInsOptions.TAG).remove(0);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        ChocolateMaltPowder chocolateMaltPowder =
                new ChocolateMaltPowder(DEFAULT_POWDERS_CHOCOLATE_MALT, DEFAULT_POWDERS_CHOCOLATE_MALT_AMOUNT);
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        VanillaBeanPowder vanillaBeanPowder =
                new VanillaBeanPowder(null, numberOfScoopByDrinkSize);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                chocolateMaltPowder, DEFAULT_POWDERS_CHOCOLATE_MALT_AMOUNT.name()
        ));
        addInsOptions.add(2, new DrinkComponentWithDefaultAsString(
                vanillaBeanPowder, Integer.toString(numberOfScoopByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(chocolateMaltPowder);
    }
}
