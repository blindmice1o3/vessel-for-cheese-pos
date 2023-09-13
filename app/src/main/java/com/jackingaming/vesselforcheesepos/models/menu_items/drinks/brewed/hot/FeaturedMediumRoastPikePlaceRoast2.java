package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class FeaturedMediumRoastPikePlaceRoast2 extends HotBrewedCoffees {
    public static final String TAG = FeaturedMediumRoastPikePlaceRoast2.class.getSimpleName();

    public static final String ID = "FeaturedMediumRoastPikePlaceRoast2";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Medium Roast Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "Well-rounded medium-roasted coffee with subtle notes of cocoa and toasted nuts balancing the smooth mouthfeel.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedMediumRoastPikePlaceRoast2() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
