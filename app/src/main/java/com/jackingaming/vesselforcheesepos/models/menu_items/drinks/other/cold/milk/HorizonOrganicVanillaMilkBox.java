package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class HorizonOrganicVanillaMilkBox extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = HorizonOrganicVanillaMilkBox.class.getSimpleName();

    public static final String ID = "HorizonOrganicVanillaMilkBox";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Horizon Organic Vanilla Milk Box";
    public static final String DEFAULT_DESCRIPTION = "Grab a mini carton of organic milk to complement a treat from our pastry case or pack into a lunch bag. Enjoy a sip and a touch of tasty vanilla.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 21;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;
    public static final float DEFAULT_CONTAINER_SIZE = 8.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public HorizonOrganicVanillaMilkBox() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
