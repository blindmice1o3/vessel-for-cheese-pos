package com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class ToppingOptions extends DrinkComponent {
    public static final String TAG = com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions.class.getSimpleName();

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum CinnamonPowder {
        CINNAMON_POWDER;
    }

    public enum ColdFoam {
        CHOCOLATE_CREAM,
        PISTACHIO_CREAM,
        SALTED_CARAMEL_CREAM,
        VANILLA_SWEET_CREAM;
    }

    public enum Drizzle {
        CARAMEL,
        MOCHA;
    }

    public enum Topping {
        CINNAMON_DOLCE_SPRINKLES,
        COOKIE_CRUMBLE,
        SALTED_BROWN_BUTTER;
    }

    // TODO: NONE, LIGHT, MEDIUM, EXTRA;
    public enum WhippedCream {
        WHIPPED_CREAM;
    }
}
