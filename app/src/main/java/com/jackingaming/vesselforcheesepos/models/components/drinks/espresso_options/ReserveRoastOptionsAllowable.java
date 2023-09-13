package com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class ReserveRoastOptionsAllowable extends EspressoOptions {
    public static final String DEFAULT_TEXT_INIT = "Reserve Roast Options";
    public static final String ID = "ReserveRoastOptionsAllowable";

    public enum Type {
        NONE,
        STARBUCKS_RESERVE_DECAF_ESPRESSO_ROAST;
    }

    private Type type;

    public ReserveRoastOptionsAllowable(Type type) {
        super(ID);

        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getTextInit() {
        return DEFAULT_TEXT_INIT;
    }

    @Override
    public String[] getEnumValuesAsStringArray() {
        Type[] enumValues = Type.values();
        String[] enumValuesAsStringArray = new String[enumValues.length];
        for (int i = 0; i < enumValues.length; i++) {
            enumValuesAsStringArray[i] = enumValues[i].name();
        }
        return enumValuesAsStringArray;
    }

    @Override
    public String getClassAsString() {
        return ReserveRoastOptionsAllowable.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return (type == null) ? NULL_TYPE_AS_STRING : type.name();
    }

    @Override
    public boolean setTypeByString(String typeAsString) {
        if (typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
            type = null;
            return true;
        }

        Type[] enumValues = Type.values();
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i].name().equals(typeAsString)) {
                type = enumValues[i];
                return true;
            }
        }

        return false;
    }
}
