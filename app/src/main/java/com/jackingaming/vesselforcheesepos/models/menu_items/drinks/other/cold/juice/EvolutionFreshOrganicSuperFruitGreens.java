package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class EvolutionFreshOrganicSuperFruitGreens extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = EvolutionFreshOrganicSuperFruitGreens.class.getSimpleName();

    public static final String ID = "EvolutionFreshOrganicSuperFruitGreens";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Evolution Fresh Organic Super Fruit Greens";
    public static final String DEFAULT_DESCRIPTION = "Here's a satisfying way to get your greens: a fruit and vegetable smoothie packed with goodness including mango puree, spinach, spirulina, chlorella, and Vitamin C. Made with 100% juice and no added sweeteners or artificial flavors.";
    public static final int DEFAULT_CALORIES = 180;
    public static final int DEFAULT_SUGAR_IN_GRAM = 36;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 11.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public EvolutionFreshOrganicSuperFruitGreens() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
