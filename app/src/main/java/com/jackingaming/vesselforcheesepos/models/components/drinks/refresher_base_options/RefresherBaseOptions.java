package com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options;

import android.util.Log;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        String nameRefresherBaseOptions = null;
        if (refresherBase != null) {
            nameRefresherBaseOptions = RefresherBase.class.getSimpleName() + ": " + refresherBase.name();
        } else {
            String errorMessage = RefresherBaseOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameRefresherBaseOptions = errorMessage;
        }
        return nameRefresherBaseOptions;
    }
}
