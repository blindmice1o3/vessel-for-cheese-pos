package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.Juice;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.IcedTea;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.Other;

import java.util.ArrayList;
import java.util.List;

public abstract class ColdOther extends Other {
    public static final String TAG = ColdOther.class.getSimpleName();

    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED, DrinkSize.TRENTA};

    public static final Granular.Amount DEFAULT_ICED_TEA_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_JUICE_AMOUNT = Granular.Amount.NO;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_COLD_FOAM_AMOUNT = Granular.Amount.NO;
    public static final String DEFAULT_FRUITS = DrinkComponent.NULL_TYPE_AS_STRING;

    public ColdOther() {
    }

    public ColdOther(String id, int imageResourceId, String name, String description,
                     int calories, int sugarInGram, float fatInGram,
                     double price) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;

        // TEA_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(new DrinkComponentWithDefaultAsString(
                new IcedTea(null, DEFAULT_ICED_TEA_AMOUNT), DEFAULT_ICED_TEA_AMOUNT.name()
        ));

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // JUICE_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> juiceOptions = new ArrayList<>();
        juiceOptions.add(new DrinkComponentWithDefaultAsString(
                new Juice(null, DEFAULT_JUICE_AMOUNT), DEFAULT_JUICE_AMOUNT.name()
        ));

        drinkComponents.put(JuiceOptions.TAG, juiceOptions);

        // SWEETENER_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> sweetenerOptions = new ArrayList<>();
        sweetenerOptions.add(new DrinkComponentWithDefaultAsString(
                new Liquid(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS)
        ));

        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);

        // FLAVOR_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> flavorOptions = new ArrayList<>();
        flavorOptions.add(new DrinkComponentWithDefaultAsString(
                new Syrup(null, Incrementable.QUANTITY_FOR_INVOKER), Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS)
        ));

        drinkComponents.put(FlavorOptions.TAG, flavorOptions);

        // TOPPING_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> toppingOptions = new ArrayList<>();
        toppingOptions.add(new DrinkComponentWithDefaultAsString(
                new ColdFoam(null, DEFAULT_COLD_FOAM_AMOUNT), DEFAULT_COLD_FOAM_AMOUNT.name()
        ));

        drinkComponents.put(ToppingOptions.TAG, toppingOptions);

        // ADD_INS_OPTIONS (add into NEW DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Fruits(Fruits.DUMMY_ID), DEFAULT_FRUITS
        ));

        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case TALL:
            case GRANDE:
            case VENTI_ICED:
                numberOfScoopNew = 1;
                break;
            case TRENTA:
                numberOfScoopNew = 2;
                break;
            case KID:
            case SHORT:
            case VENTI_HOT:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfScoopNew;
    }
}
