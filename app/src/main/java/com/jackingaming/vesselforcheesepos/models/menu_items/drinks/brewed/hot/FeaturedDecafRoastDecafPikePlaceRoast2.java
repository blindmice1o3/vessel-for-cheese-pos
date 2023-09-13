package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class FeaturedDecafRoastDecafPikePlaceRoast2 extends HotBrewedCoffees {
    public static final String TAG = FeaturedDecafRoastDecafPikePlaceRoast2.class.getSimpleName();

    public static final String ID = "FeaturedDecafRoastDecafPikePlaceRoast2";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Decaf Roast Decaf Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "A smooth, well-rounded decaf blend of Latin American coffees with subtly rich flavors of cocoa and toasted nuts--a signature cup perfect for every day.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedDecafRoastDecafPikePlaceRoast2() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
