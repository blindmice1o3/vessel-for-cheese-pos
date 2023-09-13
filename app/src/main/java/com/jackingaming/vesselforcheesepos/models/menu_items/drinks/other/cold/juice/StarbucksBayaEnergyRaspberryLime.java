package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.NotHandCrafted;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.ColdOther;

public class StarbucksBayaEnergyRaspberryLime extends ColdOther
        implements NotHandCrafted {
    public static final String TAG = StarbucksBayaEnergyRaspberryLime.class.getSimpleName();

    public static final String ID = "StarbucksBayaEnergyRaspberryLime";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Baya Energy Raspberry Lime";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Baya Energy Raspberry Lime crafted with the brightness of raspberry juice and a spritz of lime to lift you with some feel-good energy. It comes with 160 mg of caffeine naturally found in the fruit of the coffee plant. Taste how Starbucks does energy!";
    public static final int DEFAULT_CALORIES = 90;
    public static final int DEFAULT_SUGAR_IN_GRAM = 22;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;
    public static final float DEFAULT_CONTAINER_SIZE = 12.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public StarbucksBayaEnergyRaspberryLime() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }

    @Override
    public float getContainerSize() {
        return DEFAULT_CONTAINER_SIZE;
    }
}
