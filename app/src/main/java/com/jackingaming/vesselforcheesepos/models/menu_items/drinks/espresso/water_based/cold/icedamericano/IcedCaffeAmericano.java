package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.cold.icedamericano;

import com.jackingaming.vesselforcheesepos.R;

public class IcedCaffeAmericano extends IcedAmericano {
    public static final String TAG = IcedCaffeAmericano.class.getSimpleName();

    public static final String ID = "IcedCaffeAmericano";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Caffe Americano";
    public static final String DEFAULT_DESCRIPTION = "Espresso shots topped with cold water produce a light layer of crema, then served over ice. The result: a wonderfully rich cup with depth and nuance. Pro Tip: For an additional boost, ask your barista to try this with an extra shot.";
    public static final int DEFAULT_CALORIES = 15;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCaffeAmericano() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
