package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.hot.americanos;

import com.jackingaming.vesselforcheesepos.R;

public class CaffeAmericano extends Americanos {
    public static final String TAG = CaffeAmericano.class.getSimpleName();

    public static final String ID = "CaffeAmericano";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caffe Americano";
    public static final String DEFAULT_DESCRIPTION = "Espresso shots topped with hot water create a light layer of crema culminating in this wonderfully rich cup with depth and nuance.";
    public static final int DEFAULT_CALORIES = 15;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CaffeAmericano() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
