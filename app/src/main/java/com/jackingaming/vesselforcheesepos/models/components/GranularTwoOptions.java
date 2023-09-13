package com.jackingaming.vesselforcheesepos.models.components;

public interface GranularTwoOptions extends Granular {
    enum Option {STANDARD, NO_WATER_YES_EXTRA_REFRESHER_BASE;}

    Option getOption();

    void setOption(Option option);
}
