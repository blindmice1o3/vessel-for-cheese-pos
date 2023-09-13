package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class FeaturedBlondeRoast extends HotBrewedCoffees {
    public static final String TAG = FeaturedBlondeRoast.class.getSimpleName();

    public static final String ID = "FeaturedBlondeRoast";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Blonde Roast";
    public static final String DEFAULT_DESCRIPTION = "Discover one of our featured Starbucks Blonde Roasts, radiant blends that awaken your senses with delicate flavors and vibrant aromas. These enchanting brews deliver a smooth and invigorating experience that will brighten your mornings and elevate your coffee moments.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedBlondeRoast() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
