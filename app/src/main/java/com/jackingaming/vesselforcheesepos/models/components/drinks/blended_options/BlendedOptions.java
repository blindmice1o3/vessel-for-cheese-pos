package com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class BlendedOptions extends DrinkComponent {
    public static final String TAG = BlendedOptions.class.getSimpleName();

    public enum FrapRoast {
        FRAP_ROAST;
    }

    public enum FrapChips {
        FRAP_CHIPS;
    }

    public enum BlendedPrep {
        NONE,
        DOUBLE_BLENDED;
    }
}