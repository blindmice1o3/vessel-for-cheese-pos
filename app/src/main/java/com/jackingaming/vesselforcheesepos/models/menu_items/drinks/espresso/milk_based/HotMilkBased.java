package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.Espresso;

import java.util.ArrayList;
import java.util.List;

public abstract class HotMilkBased extends Espresso {
    public static final String TAG = HotMilkBased.class.getSimpleName();

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;

    public HotMilkBased() {
    }

    public HotMilkBased(String id, int imageResourceId, String name, String description,
                        int calories, int sugarInGram, float fatInGram,
                        double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);
        Temperature temperatureMedium = new Temperature(DEFAULT_TEMPERATURE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                temperatureMedium, DEFAULT_TEMPERATURE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);
        drinkComponentsStandardRecipe.add(temperatureMedium);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Powders(Powders.DUMMY_ID), DEFAULT_POWDERS
        ));
    }
}
