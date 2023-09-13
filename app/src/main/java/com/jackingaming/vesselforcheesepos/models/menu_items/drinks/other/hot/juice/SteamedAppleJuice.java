package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.juice;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.HotOther;

import java.util.ArrayList;
import java.util.List;

public class SteamedAppleJuice extends HotOther {
    public static final String TAG = SteamedAppleJuice.class.getSimpleName();

    public static final String ID = "SteamedAppleJuice";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Steamed Apple Juice";
    public static final String DEFAULT_DESCRIPTION = "Freshly steamed 100% apple juice (not from concentrate). Feel the apple goodness in this classic fruit drink that will soothe and embolden your day.";
    public static final int DEFAULT_CALORIES = 220;
    public static final int DEFAULT_SUGAR_IN_GRAM = 50;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final int DEFAULT_NUMBER_OF_CHAI_PUMPS = 0;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final String DEFAULT_FRUITS = DrinkComponent.NULL_TYPE_AS_STRING;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public SteamedAppleJuice() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        Temperature temperatureMedium = new Temperature(DEFAULT_TEMPERATURE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                temperatureMedium, DEFAULT_TEMPERATURE.name()
        ));
        drinkComponentsStandardRecipe.add(temperatureMedium);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new Chai(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_CHAI_PUMPS)
        ));

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // TOPPING_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                new WhippedCream(null, DEFAULT_WHIPPED_CREAM_AMOUNT), DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));

        drinkComponents.put(ToppingOptions.TAG, toppingOptions);

        // ADD_INS_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Fruits(Fruits.DUMMY_ID), DEFAULT_FRUITS
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Ice(null, DEFAULT_ICE_AMOUNT), DEFAULT_ICE_AMOUNT.name()
        ));
        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }
}
