package com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.views.viewport.CustomizedDrinkComponentAdapter;

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

    private MilkBase milkBase;
    private Temperature temperature;
    private MilkFoam milkFoam;
    private CappuccinoFoam cappuccinoFoam;

    public MilkOptions(MilkBase milkBase) {
        this.milkBase = milkBase;
    }

    public MilkOptions(Temperature temperature) {
        this.temperature = temperature;
    }

    public MilkOptions(MilkFoam milkFoam) {
        this.milkFoam = milkFoam;
    }

    public MilkOptions(CappuccinoFoam cappuccinoFoam) {
        this.cappuccinoFoam = cappuccinoFoam;
    }

    public MilkBase getMilkBase() {
        return milkBase;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public MilkFoam getMilkFoam() {
        return milkFoam;
    }

    public CappuccinoFoam getCappuccinoFoam() {
        return cappuccinoFoam;
    }

    @NonNull
    @Override
    public String toString() {
        String nameMilkOptions = null;
        if (milkBase != null) {
            nameMilkOptions = MilkBase.class.getSimpleName() + ": " + milkBase.name();
        } else if (temperature != null) {
            nameMilkOptions = Temperature.class.getSimpleName() + ": " + temperature.name();
        } else if (milkFoam != null) {
            nameMilkOptions = MilkFoam.class.getSimpleName() + ": " + milkFoam.name();
        } else if (cappuccinoFoam != null) {
            nameMilkOptions = CappuccinoFoam.class.getSimpleName() + ": " + cappuccinoFoam.name();
        } else {
            String errorMessage = MilkOptions.class.getSimpleName() + ".toString() else-clause";
            Log.e(TAG, errorMessage);
            nameMilkOptions = errorMessage;
        }
        return nameMilkOptions;
    }
}
