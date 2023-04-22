package com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class FlavorOptions extends DrinkComponent {
    public static final String TAG = FlavorOptions.class.getSimpleName();

    public enum Sauce {
        DARK_CARAMEL,
        MOCHA,
        PISTACHIO,
        WHITE_CHOCOLATE_MOCHA;
    }

    public enum Syrup {
        BROWN_SUGAR,
        CARAMEL,
        CINNAMON_DOLCE,
        HAZELNUT,
        PEPPERMINT,
        RASPBERRY,
        SUGAR_FREE_VANILLA,
        TOASTED_VANILLA,
        TOFFEE_NUT,
        VANILLA;
    }

    private Sauce sauce;
    private Syrup syrup;

    public FlavorOptions(Sauce sauce) {
        this.sauce = sauce;
    }

    public FlavorOptions(Syrup syrup) {
        this.syrup = syrup;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Syrup getSyrup() {
        return syrup;
    }
}
