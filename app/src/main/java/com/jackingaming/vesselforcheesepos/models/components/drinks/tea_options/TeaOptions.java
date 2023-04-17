package com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class TeaOptions extends DrinkComponent {
    public static final String TAG = TeaOptions.class.getSimpleName();

    public enum Chai {
        CHAI;
    }

    public enum IcedTeaBase {
        BLACK_TEA,
        GREEN_TEA,
        PASSION_TANGO_TEA;
    }

    public enum IcedTeaSplash {
        BLACK_TEA,
        GREEN_TEA,
        PASSION_TANGO_TEA;
    }

    public enum MatchaPowder {
        MATCHA_POWDER;
    }

    public enum TeaBag {
        TEA_BAG;
    }

    public enum Extras {
        EXTRA_NONE,
        EXTRA_LEMONADE,
        EXTRA_TEA;
    }
}
