package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;

import java.util.ArrayList;
import java.util.List;

public class IcedCoffeeWithMilk extends IcedCoffees {
    public static final String TAG = IcedCoffeeWithMilk.class.getSimpleName();

    public static final String ID = "IcedCoffeeWithMilk";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Coffee with Milk";
    public static final String DEFAULT_DESCRIPTION = "Freshly brewed Starbucks Iced Coffee Blend with milk served chilled and sweetened over ice. An absolutely, seriously, refreshingly lift to any day.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 23;
    public static final float DEFAULT_FAT_IN_GRAM = 1.5f;

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCoffeeWithMilk() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);

        drinkComponents.put(MilkOptions.TAG, milkOptions);
    }
}
