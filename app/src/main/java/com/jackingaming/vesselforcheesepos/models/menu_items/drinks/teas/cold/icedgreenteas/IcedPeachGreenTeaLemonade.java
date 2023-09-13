package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.Juice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBases;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBasesOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Extras;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.MatchaPowder;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.IcedTeas;

import java.util.ArrayList;
import java.util.List;

public class IcedPeachGreenTeaLemonade extends IcedTeas {
    public static final String TAG = IcedPeachGreenTeaLemonade.class.getSimpleName();

    public static final String ID = "IcedPeachGreenTeaLemonade";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Peach Green Tea Lemonade";
    public static final String DEFAULT_DESCRIPTION = "Green tea is layered together with flavors of spearmint, lemon verbena, lemongrass and a splash of lemonade over ice for a patio-ready refreshment of surprise and delight.";
    public static final int DEFAULT_CALORIES = 80;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Lemonade.Type DEFAULT_LEMONADE = Lemonade.Type.LEMONADE;
    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.MEDIUM;
    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final Granular.Amount DEFAULT_REFRESHER_BASE_AMOUNT = Granular.Amount.NO;
    public static final Extras.Type DEFAULT_EXTRAS = Extras.Type.NO;
    public static final int DEFAULT_NUMBER_OF_MATCHA_SCOOPS = 0;
    public static final Juice.Type DEFAULT_JUICE_PEACH = Juice.Type.PEACH_JUICE_BLEND;
    public static final Granular.Amount DEFAULT_JUICE_PEACH_AMOUNT = Granular.Amount.MEDIUM;
    public static final Granular.Amount DEFAULT_JUICE_APPLE_AMOUNT = Granular.Amount.NO;
    public static final String DEFAULT_FRUITS = DrinkComponent.NULL_TYPE_AS_STRING;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedPeachGreenTeaLemonade() {
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

        // REFRESHER_BASE_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> refresherBaseOptions = new ArrayList<>();
        refresherBaseOptions.add(new DrinkComponentWithDefaultAsString(
                new RefresherBases(null, DEFAULT_REFRESHER_BASE_AMOUNT), DEFAULT_REFRESHER_BASE_AMOUNT.name()
        ));

        drinkComponents.put(RefresherBasesOptions.TAG, refresherBaseOptions);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        Extras extras = new Extras(DEFAULT_EXTRAS);

        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                extras, DEFAULT_EXTRAS.name()
        ));
        teaOptions.add(1, new DrinkComponentWithDefaultAsString(
                new MatchaPowder(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_MATCHA_SCOOPS)
        ));
        drinkComponentsStandardRecipe.add(extras);

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // JUICE_OPTIONS (add into NEW DrinkComponent group)
        Juice juicePeach = new Juice(DEFAULT_JUICE_PEACH, DEFAULT_JUICE_PEACH_AMOUNT);

        List<DrinkComponentWithDefaultAsString> juiceOptions = new ArrayList<>();
        juiceOptions.add(0, new DrinkComponentWithDefaultAsString(
                juicePeach, DEFAULT_JUICE_PEACH_AMOUNT.name()
        ));
        juiceOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Juice(null, DEFAULT_JUICE_APPLE_AMOUNT), DEFAULT_JUICE_APPLE_AMOUNT.name()
        ));

        drinkComponents.put(JuiceOptions.TAG, juiceOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Fruits(Fruits.DUMMY_ID), DEFAULT_FRUITS
        ));
    }
}
