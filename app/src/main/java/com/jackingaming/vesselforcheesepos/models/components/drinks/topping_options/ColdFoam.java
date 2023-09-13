package com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options;

import com.jackingaming.vesselforcheesepos.models.components.Granular;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class ColdFoam extends ToppingOptions
        implements Granular {
    public static final String DEFAULT_TEXT_INIT = "Add Cold Foam";
    public static final String ID = "ColdFoam";

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public enum Type {
        CHOCOLATE_CREAM_COLD_FOAM,
        CINNAMON_SWEET_CREAM_COLD_FOAM,
        MATCHA_CREAM_COLD_FOAM,
        PUMPKIN_CREAM_COLD_FOAM,
        SALTED_CARAMEL_CREAM_COLD_FOAM,
        VANILLA_SWEET_CREAM_COLD_FOAM;
    }

    private Type type;
    private Amount amount;

    public ColdFoam(Type type, Amount amount) {
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
        return ColdFoam.class.getSimpleName();
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
        ColdFoam coldFoam = new ColdFoam(null, amount);
        coldFoam.setTypeByString(typeAsString);
        return coldFoam;
    }
}
