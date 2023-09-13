package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class CloverStarbucksReserveVietnamDaLat extends HotBrewedCoffees {
    public static final String TAG = CloverStarbucksReserveVietnamDaLat.class.getSimpleName();

    public static final String ID = "CloverStarbucksReserveVietnamDaLat";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Clover Starbucks Reserve Vietnam Da Lat";
    public static final String DEFAULT_DESCRIPTION = "Cocoa Peel and Toffee Nut Anchors by the city of Da Lat, Vietnam's Lam Dong Province provides a dreamlike setting for coffee cultivation--mist-shrouded pine forests, cool temperatures and volcanic soil. Farmers load just-picked coffee cherries onto small motorbikes and travel over rugged terrain to deliver high-quality crops. Their dedication culminates in this--a coffee every bit as distinctive as the land from which it came.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CloverStarbucksReserveVietnamDaLat() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
