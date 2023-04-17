package com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class SweetenerOptions extends DrinkComponent {
    public static final String TAG = SweetenerOptions.class.getSimpleName();

    public enum Liquid {
        CLASSIC,
        HONEY_BLEND,
        LIQUID_CANE;
    }

    public enum Packet {
        HONEY,
        SPLENDA,
        STEVIA_IN_THE_RAW,
        SUGAR,
        SUGAR_IN_THE_RAW;
    }
}
