package com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class MilkOptions extends DrinkComponent {
    public static final String TAG = MilkOptions.class.getSimpleName();

    public enum MilkBase {
        TWO_PERCENT,
        BREVE,
        COCONUT,
        HEAVY_CREAM,
        NONFAT_MILK,
        OATMILK,
        SOY,
        VANILLA_SWEET_CREAM,
        WHOLE_MILK,
        ALMOND;
    }

    public enum Temperature {
        WARM, MEDIUM, EXTRA;
    }

    public enum MilkFoam {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    public enum CappuccinoFoam {
        EXTRA_DRY, DRY, MEDIUM, WET, EXTRA_WET;
    }
}
