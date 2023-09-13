package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base;

import com.jackingaming.vesselforcheesepos.models.components.MixedType;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;

import java.util.ArrayList;
import java.util.List;

public class Fruits extends AddInsOptions
        implements MixedType {
    public static final String DEFAULT_TEXT_INIT = "Add Fruit Add-Ins";
    public static final String DUMMY_ID = "FRUITS";

    public enum Type {
        DRAGONFRUIT_FRUIT,
        PINEAPPLE_FRUIT,
        STRAWBERRY_FRUIT,
        STRAWBERRY_PUREE_FRUIT;
    }

    private Type type;

    public Fruits(String id) {
        super(id);
    }

    public static List<String> getEnumValuesAsStringForMixedType() {
        Type[] enumValues = Type.values();
        List<String> enumValuesAsString = new ArrayList<>();
        for (int i = 0; i < enumValues.length; i++) {
            enumValuesAsString.add(
                    enumValues[i].name()
            );
        }
        return enumValuesAsString;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getTextInit() {
        return (type == null) ? (DEFAULT_TEXT_INIT) : ("Add " + type.name());
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
        return Fruits.class.getSimpleName();
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
