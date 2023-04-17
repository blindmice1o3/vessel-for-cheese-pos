package com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class CupOptions extends DrinkComponent {
    public static final String TAG = CupOptions.class.getSimpleName();

    public enum CupSize {
        NONE, TALL, GRANDE, VENTI;
    }
}
