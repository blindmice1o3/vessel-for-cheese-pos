package com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class PreparationOptions extends DrinkComponent {
    public static final String TAG = PreparationMethod.class.getSimpleName();

    public enum PreparationMethod {
        NONE,
        BLENDED;
    }

    private PreparationMethod preparationMethod;

    public PreparationOptions(PreparationMethod preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public PreparationMethod getPreparationMethod() {
        return preparationMethod;
    }

    @NonNull
    @Override
    public String toString() {
        String namePreparationOptions = null;
        if (preparationMethod != null) {
            namePreparationOptions = PreparationMethod.class.getSimpleName() + ": " + preparationMethod.name();
        } else {
            String errorMessage = PreparationOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            namePreparationOptions = errorMessage;
        }
        return namePreparationOptions;
    }
}
