package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class AddInsOptions extends DrinkComponent {
    public static final String TAG = AddInsOptions.class.getSimpleName();

    public enum LineTheCup {
        NONE,
        CARAMEL_SAUCE,
        MOCHA_SAUCE;
    }

    public enum MilkCreamer {
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

    public enum Room {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    public enum Powder {
        CHOCOLATE_MALT,
        VANILLA_BEAN;
    }

    public enum Water {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    public enum Ice {
        NONE, LIGHT, MEDIUM, EXTRA;
    }

    // TODO: NONE, LIGHT, MEDIUM, EXTRA; (but only for STRAWBERRY_PUREE)
    public enum Fruit {
        DRAGONFRUIT_INCLUSION,
        PINEAPPLE_INCLUSION,
        STRAWBERRY_INCLUSION,
        STRAWBERRY_PUREE;
    }
}
