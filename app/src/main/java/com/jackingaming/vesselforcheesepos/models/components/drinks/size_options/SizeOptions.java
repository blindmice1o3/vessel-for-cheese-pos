package com.jackingaming.vesselforcheesepos.models.components.drinks.size_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class SizeOptions extends DrinkComponent {
    public static final String TAG = SizeOptions.class.getSimpleName();

    public enum Size {
        SHORT, TALL, GRANDE, VENTI, TRENTA;
    }
}
