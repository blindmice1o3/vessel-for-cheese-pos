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
}
