package com.jackingaming.vesselforcheesepos.models;

public class TwoPercentMilk extends MenuItem {
    public static final String NAME_DEFAULT = "two percent milk";
    public static final String DESCRIPTION_DEFAULT = "product of a cow's mammary glands";
    public static final double PRICE_DEFAULT = 0.50;
    public static final boolean HANDED_OFF_DEFAULT = false;

    public TwoPercentMilk() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_DEFAULT, HANDED_OFF_DEFAULT);
    }
}
