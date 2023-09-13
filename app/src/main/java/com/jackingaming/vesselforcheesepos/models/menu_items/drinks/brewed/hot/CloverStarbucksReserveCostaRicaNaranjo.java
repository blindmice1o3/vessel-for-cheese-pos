package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class CloverStarbucksReserveCostaRicaNaranjo extends HotBrewedCoffees {
    public static final String TAG = CloverStarbucksReserveCostaRicaNaranjo.class.getSimpleName();

    public static final String ID = "CloverStarbucksReserveCostaRicaNaranjo";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Clover Starbucks Reserve Costa Rica Naranjo";
    public static final String DEFAULT_DESCRIPTION = "Apricot & Almond The brilliant hues of the Costa Rican oxcart celebrate coffee's vitality in the Naranjo region, where smallholder farmers in the Naranjo Cooperative worked together to produce this elevated lot rooted in community pride.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CloverStarbucksReserveCostaRicaNaranjo() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
