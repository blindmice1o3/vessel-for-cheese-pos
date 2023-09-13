package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class EvolutionFreshOrange extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = EvolutionFreshOrange.class.getSimpleName();

    public static final String ID = "EvolutionFreshOrange";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Evolution Fresh Orange";
    public static final String DEFAULT_DESCRIPTION = "Once you try this orange juice--cold-pressed with oranges picked and squeezed at their peak of sweetness--you'll never go back to any other. Vitamin C--packed and made with 100% juice, no added sweeteners or any artificial flavors.";
    public static final int DEFAULT_CALORIES = 170;
    public static final int DEFAULT_SUGAR_IN_GRAM = 35;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 11.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public EvolutionFreshOrange() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
