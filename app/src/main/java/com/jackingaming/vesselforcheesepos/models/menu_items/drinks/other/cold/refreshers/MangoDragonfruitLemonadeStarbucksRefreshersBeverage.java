package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBaseAllowable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

import java.util.ArrayList;
import java.util.List;

public class MangoDragonfruitLemonadeStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = MangoDragonfruitLemonadeStarbucksRefreshersBeverage.class.getSimpleName();

    public static final String ID = "MangoDragonfruitLemonadeStarbucksRefreshersBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Mango Dragonfruit Lemonade Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "This tropical-inspired pick-me-up--crafted with a clever combination of vibrant lemonade, sweet mango and refreshing dragonfruit flavors and hand-shaken with ice plus a scoop of real diced dragonfruit.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 31;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Lemonade.Type DEFAULT_LEMONADE = Lemonade.Type.LEMONADE;
    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.MEDIUM;
    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final MilkBaseAllowable.Type DEFAULT_MILK_BASE_ALLOWABLE = MilkBaseAllowable.Type.NO;
    public static final FruitInclusion.Type DEFAULT_FRUIT_INCLUSION_DRAGONFRUIT = FruitInclusion.Type.DRAGONFRUIT_INCLUSION;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public MangoDragonfruitLemonadeStarbucksRefreshersBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // LEMONADE_OPTIONS
        Lemonade lemonade = new Lemonade(DEFAULT_LEMONADE, DEFAULT_LEMONADE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                lemonade, DEFAULT_LEMONADE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(lemonade);

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);

        // PREPARATION_OPTIONS (add into NEW DrinkComponent group)
        PreparationMethod preparationMethod = new PreparationMethod(DEFAULT_PREPARATION_METHOD);

        List<DrinkComponentWithDefaultAsString> preparationOptions = new ArrayList<>();
        preparationOptions.add(new DrinkComponentWithDefaultAsString(
                preparationMethod, DEFAULT_PREPARATION_METHOD.name()
        ));
        drinkComponentsStandardRecipe.add(preparationMethod);

        drinkComponents.put(PreparationOptions.TAG, preparationOptions);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBaseAllowable milkBaseAllowable = new MilkBaseAllowable(DEFAULT_MILK_BASE_ALLOWABLE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseAllowable, DEFAULT_MILK_BASE_ALLOWABLE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseAllowable);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        FruitInclusion fruitInclusionDragonfruit = new FruitInclusion(DEFAULT_FRUIT_INCLUSION_DRAGONFRUIT, numberOfScoopByDrinkSize);
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                fruitInclusionDragonfruit, Integer.toString(numberOfScoopByDrinkSize)
        ));
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(fruitInclusionDragonfruit);
        drinkComponentsStandardRecipe.add(ice);
    }
}
