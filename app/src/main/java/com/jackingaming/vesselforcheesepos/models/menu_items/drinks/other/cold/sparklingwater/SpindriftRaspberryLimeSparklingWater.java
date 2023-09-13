package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.sparklingwater;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class SpindriftRaspberryLimeSparklingWater extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = SpindriftRaspberryLimeSparklingWater.class.getSimpleName();

    public static final String ID = "SpindriftRaspberryLimeSparklingWater";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Spindrift Raspberry Lime Sparkling Water";
    public static final String DEFAULT_DESCRIPTION = "Raspberry and lime squeezed into sparkling water for an effervescent, delightfully refreshing beverage.";
    public static final int DEFAULT_CALORIES = 9;
    public static final int DEFAULT_SUGAR_IN_GRAM = 1;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 12.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public SpindriftRaspberryLimeSparklingWater() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
