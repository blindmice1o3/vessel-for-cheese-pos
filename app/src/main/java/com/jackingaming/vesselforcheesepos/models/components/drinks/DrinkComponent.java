package com.jackingaming.vesselforcheesepos.models.components.drinks;

import java.io.Serializable;

public abstract class DrinkComponent
        implements Serializable {
    public static final String TAG = DrinkComponent.class.getSimpleName();
    public static final String NULL_TYPE_AS_STRING = "null";

    public DrinkComponent(String id) {
        this.id = id;
    }

    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getTextInit();

    public abstract String[] getEnumValuesAsStringArray();

    public abstract String getClassAsString();

    public abstract String getTypeAsString();

    public abstract boolean setTypeByString(String typeAsString);
}
