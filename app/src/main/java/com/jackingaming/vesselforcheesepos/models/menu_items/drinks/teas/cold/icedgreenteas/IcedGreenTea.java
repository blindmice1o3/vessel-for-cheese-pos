package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Water;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.Juice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBases;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBasesOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.MatchaPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.IcedTeas;

import java.util.ArrayList;
import java.util.List;

public class IcedGreenTea extends IcedTeas {
    public static final String TAG = IcedGreenTea.class.getSimpleName();

    public static final String ID = "IcedGreenTea";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Green Tea";
    public static final String DEFAULT_DESCRIPTION = "Green tea blended with mint, lemongrass and lemon verbena, and given a good shake with ice. Lightly flavored and oh-so-refreshing!";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final Granular.Amount DEFAULT_REFRESHER_BASE_AMOUNT = Granular.Amount.NO;
    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_MATCHA_SCOOPS = 0;
    public static final Granular.Amount DEFAULT_JUICE_AMOUNT = Granular.Amount.NO;
    public static final Water.Type DEFAULT_WATER = Water.Type.WATER;
    public static final Granular.Amount DEFAULT_WATER_AMOUNT = Granular.Amount.MEDIUM;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final String DEFAULT_FRUITS = DrinkComponent.NULL_TYPE_AS_STRING;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedGreenTea() {
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

        // REFRESHER_BASE_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> refresherBaseOptions = new ArrayList<>();
        refresherBaseOptions.add(new DrinkComponentWithDefaultAsString(
                new RefresherBases(null, DEFAULT_REFRESHER_BASE_AMOUNT), DEFAULT_REFRESHER_BASE_AMOUNT.name()
        ));

        drinkComponents.put(RefresherBasesOptions.TAG, refresherBaseOptions);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
        ));
        teaOptions.add(1, new DrinkComponentWithDefaultAsString(
                new MatchaPowder(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_MATCHA_SCOOPS)
        ));

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // JUICE_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> juiceOptions = new ArrayList<>();
        juiceOptions.add(new DrinkComponentWithDefaultAsString(
                new Juice(null, DEFAULT_JUICE_AMOUNT), DEFAULT_JUICE_AMOUNT.name()
        ));

        drinkComponents.put(JuiceOptions.TAG, juiceOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        Water water = new Water(DEFAULT_WATER, DEFAULT_WATER_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                water, DEFAULT_WATER_AMOUNT.name()
        ));
        addInsOptions.add(2, new DrinkComponentWithDefaultAsString(
                new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT), DEFAULT_MILK_CREAMER_AMOUNT.name()
        ));
        addInsOptions.add(3, new DrinkComponentWithDefaultAsString(
                new Fruits(Fruits.DUMMY_ID), DEFAULT_FRUITS
        ));
        drinkComponentsStandardRecipe.add(water);
    }
}
