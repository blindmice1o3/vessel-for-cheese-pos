package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.derived;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;

import java.util.ArrayList;
import java.util.List;

public class StrawberryPuree extends Fruits
        implements Granular {
    public static final String DEFAULT_TEXT_INIT = "Add Strawberry Puree";
    public static final String ID = "StrawberryPuree";

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public enum Type {
        STRAWBERRY_PUREE;
    }

    private Type type;
    private Amount amount;

    public StrawberryPuree(Type type, Amount amount) {
        super(ID);

        this.type = type;
        this.amount = amount;
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

    public Type getTypeUnmixed() {
        return type;
    }

    public void setTypeUnmixed(Type type) {
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
        return StrawberryPuree.class.getSimpleName();
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

    @Override
    public DrinkComponent newInstanceViaTypeAsString(String typeAsString, Amount amount) {
        StrawberryPuree strawberryPuree = new StrawberryPuree(null, amount);
        strawberryPuree.setTypeByString(typeAsString);
        return strawberryPuree;
    }
}
