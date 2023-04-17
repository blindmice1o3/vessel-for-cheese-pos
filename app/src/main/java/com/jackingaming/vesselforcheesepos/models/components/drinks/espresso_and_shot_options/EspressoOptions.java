package com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_and_shot_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class EspressoOptions extends DrinkComponent {
    public static final String TAG = EspressoOptions.class.getSimpleName();

    public enum Shot {
        SHOT
    }

    public enum AffogatoShot {
        AFFOGATO_SHOT;
    }

    public enum RoastOptions {
        NONE,
        BLONDE,
        SIGNATURE,
        DECAF,
        DECAF_ONE_THIRD,
        DECAF_ONE_HALF,
        DECAF_TWO_THIRD;
    }

    public enum PrepOptions {
        NONE,
        UPSIDE_DOWN;
    }

    public enum PullOptions {
        NONE,
        LONG,
        RISTRETTO;
    }

    public enum SizeOptions {
        SOLO,
        DOPPIO,
        TRIPLE,
        QUAD;
    }
}
