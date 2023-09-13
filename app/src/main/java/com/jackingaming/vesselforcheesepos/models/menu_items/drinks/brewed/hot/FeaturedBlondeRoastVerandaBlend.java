package com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesepos.R;

public class FeaturedBlondeRoastVerandaBlend extends HotBrewedCoffees {
    public static final String TAG = FeaturedBlondeRoastVerandaBlend.class.getSimpleName();

    public static final String ID = "FeaturedBlondeRoastVerandaBlend";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Blonde Roast Veranda Blend";
    public static final String DEFAULT_DESCRIPTION = "We've spent decades working with coffee farmers throughout Latin America. This blend was inspired by the lightly roasted coffees we've sipped together over the years, often enjoyed on a breezy veranda with a view of lush coffee trees. Subtle but flavorful with notes of toasted sweet malt and milk chocolate, it's an inviting, approachable coffee that mixes beautifully with milk.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedBlondeRoastVerandaBlend() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
