package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.bottledteas;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.IcedTeas;

public class TeavanaSparklingUnsweetenedPeachNectarineGreenTea extends IcedTeas
        implements NotHandCrafted {
    public static final String TAG = TeavanaSparklingUnsweetenedPeachNectarineGreenTea.class.getSimpleName();

    public static final String ID = "TeavanaSparklingUnsweetenedPeachNectarineGreenTea";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Teavana Sparkling Unsweetened Peach Nectarine Green Tea";
    public static final String DEFAULT_DESCRIPTION = "This special unsweetened combination of peach and nectarine flavors plus green tea adds a delicious sparkle of nourishment to your day.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 14.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public TeavanaSparklingUnsweetenedPeachNectarineGreenTea() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
