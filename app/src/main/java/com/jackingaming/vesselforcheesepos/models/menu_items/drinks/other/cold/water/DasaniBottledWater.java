package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class DasaniBottledWater extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = DasaniBottledWater.class.getSimpleName();

    public static final String ID = "DasaniBottledWater";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "DASANI Bottled Water";
    public static final String DEFAULT_DESCRIPTION = "DASANI Bottled Water";
    public static final int DEFAULT_CALORIES = -1;
    public static final int DEFAULT_SUGAR_IN_GRAM = -1;
    public static final float DEFAULT_FAT_IN_GRAM = -1.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 20.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public DasaniBottledWater() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
