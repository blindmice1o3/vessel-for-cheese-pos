package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class CloverMalawiSableFarmsStarbucksReserve extends HotBrewedCoffees {
    public static final String TAG = CloverMalawiSableFarmsStarbucksReserve.class.getSimpleName();

    public static final String ID = "CloverMalawiSableFarmsStarbucksReserve";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Clover Malawi Sable Farms Starbucks Reserve";
    public static final String DEFAULT_DESCRIPTION = "Citrus, Cedar & Ginger Sable Farm has a global reputation for producing top-quality coffee with environmentally-thoughtful practices. It's also a pioneer in using solar coffee dryers!";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CloverMalawiSableFarmsStarbucksReserve() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
