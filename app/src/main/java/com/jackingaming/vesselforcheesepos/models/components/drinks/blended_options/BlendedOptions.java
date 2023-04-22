package com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class BlendedOptions extends DrinkComponent {
    public static final String TAG = BlendedOptions.class.getSimpleName();

    public enum FrapRoast {
        FRAP_ROAST;
    }

    public enum FrapChips {
        FRAP_CHIPS;
    }

    public enum BlendedPrep {
        NONE,
        DOUBLE_BLENDED;
    }

    private FrapRoast frapRoast;
    private FrapChips frapChips;
    private BlendedPrep blendedPrep;

    public BlendedOptions(FrapRoast frapRoast) {
        this.frapRoast = frapRoast;
    }

    public BlendedOptions(FrapChips frapChips) {
        this.frapChips = frapChips;
    }

    public BlendedOptions(BlendedPrep blendedPrep) {
        this.blendedPrep = blendedPrep;
    }

    public FrapRoast getFrapRoast() {
        return frapRoast;
    }

    public FrapChips getFrapChips() {
        return frapChips;
    }

    public BlendedPrep getBlendedPrep() {
        return blendedPrep;
    }
}
