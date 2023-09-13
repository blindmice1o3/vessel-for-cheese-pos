package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

import java.util.ArrayList;
import java.util.List;

public class ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam extends ColdOther {
    public static final String TAG = ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam.class.getSimpleName();

    public static final String ID = "ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Paradise Drink Starbucks Refreshers Beverage with Oleato Golden Foam";
    public static final String DEFAULT_DESCRIPTION = "Tropical flavors of pineapple and passionfruit combine with diced pineapple and creamy coconutmilk to create a delicious island escape. Topped with lush Partanna extra virgin olive oil infused cold foam.";
    public static final int DEFAULT_CALORIES = 460;
    public static final int DEFAULT_SUGAR_IN_GRAM = 29;
    public static final float DEFAULT_FAT_IN_GRAM = 36.0f;

    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final MilkBase.Type DEFAULT_MILK_BASE_COCONUT = MilkBase.Type.COCONUT;
    public static final FruitInclusion.Type DEFAULT_FRUIT_INCLUSION_PINEAPPLE = FruitInclusion.Type.PINEAPPLE_INCLUSION;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam() {
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

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseCoconut = new MilkBase(DEFAULT_MILK_BASE_COCONUT);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseCoconut, DEFAULT_MILK_BASE_COCONUT.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseCoconut);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        FruitInclusion fruitInclusionPineapple = new FruitInclusion(DEFAULT_FRUIT_INCLUSION_PINEAPPLE, numberOfScoopByDrinkSize);
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                fruitInclusionPineapple, Integer.toString(numberOfScoopByDrinkSize)
        ));
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(fruitInclusionPineapple);
        drinkComponentsStandardRecipe.add(ice);
    }
}
