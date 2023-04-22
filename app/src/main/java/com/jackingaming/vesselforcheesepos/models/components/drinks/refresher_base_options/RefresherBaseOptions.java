package com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class RefresherBaseOptions extends DrinkComponent {
    public static final String TAG = RefresherBaseOptions.class.getSimpleName();

    public enum RefresherBase {
        KIWI_STARFRUIT,
        MANGO_DRAGONFRUIT,
        PINEAPPLE_PASSIONFRUIT,
        STRAWBERRY_ACAI;
    }

    private RefresherBase refresherBase;

    public RefresherBaseOptions(RefresherBase refresherBase) {
        this.refresherBase = refresherBase;
    }

    public RefresherBase getRefresherBase() {
        return refresherBase;
    }
}
