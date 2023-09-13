package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;

import java.util.ArrayList;
import java.util.List;

public class StarbucksColdBrewCoffeeWithMilk extends ColdBrews {
    public static final String TAG = StarbucksColdBrewCoffeeWithMilk.class.getSimpleName();

    public static final String ID = "StarbucksColdBrewCoffeeWithMilk";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Cold Brew Coffee with Milk";
    public static final String DEFAULT_DESCRIPTION = "Handcrafted in small batches daily, slow-steeped in cool water for 20 hours, without touching heat and finished with a splash of milk--Starbucks Cold Brew is made from our custom blend of beans grown to steep long and cold for a super-smooth flavor.";
    public static final int DEFAULT_CALORIES = 35;
    public static final int DEFAULT_SUGAR_IN_GRAM = 3;
    public static final float DEFAULT_FAT_IN_GRAM = 1.5f;

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksColdBrewCoffeeWithMilk() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));

        drinkComponents.put(MilkOptions.TAG, milkOptions);
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);
    }
}
