package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.travelers;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;

public class TravelerPikePlaceRoast extends CoffeeTravelers
        implements NotHandCrafted {
    public static final String TAG = TravelerPikePlaceRoast.class.getSimpleName();

    public static final String ID = "TravelerPikePlaceRoast";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Coffee Traveler - Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "A convenient carrier filled with 96 fl oz of our featured brewed medium roast coffee (equivalent of twelve 8 fl oz cups)--a perfect pick-me-up for meetings, picnics or whatever occasion calls for coffee.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = -1.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public TravelerPikePlaceRoast() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
