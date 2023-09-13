package com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class Lemonade extends LemonadeOptions
        implements Granular {
    public static final String DEFAULT_TEXT_INIT = "Add Lemonade";
    public static final String ID = "Lemonade";

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public enum Type {
        LEMONADE;
    }

    private Type type;
    private Amount amount;

    public Lemonade(Type type, Amount amount) {
        super(ID);

        this.type = type;
        this.amount = amount;
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
        return Lemonade.class.getSimpleName();
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
        Lemonade lemonade = new Lemonade(null, amount);
        lemonade.setTypeByString(typeAsString);
        return lemonade;
    }
}
