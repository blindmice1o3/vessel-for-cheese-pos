package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class FeaturedDarkRoastCaffeVerona extends HotBrewedCoffees {
    public static final String TAG = FeaturedDarkRoastCaffeVerona.class.getSimpleName();

    public static final String ID = "FeaturedDarkRoastCaffeVerona";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Dark Roast Caffe Verona";
    public static final String DEFAULT_DESCRIPTION = "Well-balanced and rich with a dark cocoa texture. Try it with a piece of dark chocolate to bring out even more sweetness.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedDarkRoastCaffeVerona() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
