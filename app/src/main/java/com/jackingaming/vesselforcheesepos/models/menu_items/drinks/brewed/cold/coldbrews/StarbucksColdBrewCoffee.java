package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesepos.R;

public class StarbucksColdBrewCoffee extends ColdBrews {
    public static final String TAG = StarbucksColdBrewCoffee.class.getSimpleName();

    public static final String ID = "StarbucksColdBrewCoffee";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Cold Brew Coffee";
    public static final String DEFAULT_DESCRIPTION = "Handcrafted in small batches daily, slow-steeped in cool water for 20 hours, without touching heat--Starbucks Cold Brew is made from our custom blend of beans grown to steep long and cold for a super-smooth flavor.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksColdBrewCoffee() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
