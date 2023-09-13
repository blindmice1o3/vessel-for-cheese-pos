package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class HorizonChocolateOrganicMilk extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = HorizonChocolateOrganicMilk.class.getSimpleName();

    public static final String ID = "HorizonChocolateOrganicMilk";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Horizon Chocolate Organic Milk";
    public static final String DEFAULT_DESCRIPTION = "Great for snacks, travel and more, this chocolate organic milk box is a convenient way to experience your milk on the go and everywhere.";
    public static final int DEFAULT_CALORIES = 150;
    public static final int DEFAULT_SUGAR_IN_GRAM = 23;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;
    public static final float DEFAULT_CONTAINER_SIZE = 8.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public HorizonChocolateOrganicMilk() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
