package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees;

import com.jackingaming.vesselforcheesepos.R;

public class IcedCoffee extends IcedCoffees {
    public static final String TAG = IcedCoffee.class.getSimpleName();

    public static final String ID = "IcedCoffee";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Coffee";
    public static final String DEFAULT_DESCRIPTION = "Freshly brewed Starbucks Iced Coffee Blend served chilled and sweetened over ice. An absolutely, seriously, refreshingly lift to any day.";
    public static final int DEFAULT_CALORIES = 80;
    public static final int DEFAULT_SUGAR_IN_GRAM = 20;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCoffee() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
