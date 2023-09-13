package com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public class Syrup extends FlavorOptions
        implements Incrementable {
    public static final String DEFAULT_TEXT_INIT = "Add Syrups";
    public static final String ID = "Syrup";

    public static final int DEFAULT_QUANTITY_MIN = 0;
    public static final int DEFAULT_QUANTITY_MAX = 12;

    private int quantityMin = DEFAULT_QUANTITY_MIN;
    private int quantityMax = DEFAULT_QUANTITY_MAX;

    @Override
    public void onIncrement() {
        Log.i(TAG, "start of onIncrement() --- quantity: " + quantity);

        if (quantity == QUANTITY_FOR_INVOKER) {
            Log.i(TAG, "quantity == QUANTITY_FOR_INVOKER");
            return;
        }

        quantity++;

        if (quantity > quantityMax) {
            Log.i(TAG, "quantity > quantityMax --- SETTING quantity = quantityMax");
            quantity = quantityMax;
        }
        Log.i(TAG, "end of onIncrement() --- quantity: " + quantity);
    }

    @Override
    public void onDecrement() {
        Log.i(TAG, "start of onDecrement() --- quantity: " + quantity);

        if (quantity == QUANTITY_FOR_INVOKER) {
            Log.i(TAG, "quantity == QUANTITY_FOR_INVOKER");
            return;
        }

        quantity--;

        if (quantity < quantityMin) {
            Log.i(TAG, "quantity < quantityMin --- SETTING quantity = quantityMin");
            quantity = quantityMin;
        }
        Log.i(TAG, "end of onDecrement() --- quantity: " + quantity);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Type {
        APPLE_BROWN_SUGAR,
        BROWN_SUGAR_SYRUP,
        CARAMEL_SYRUP,
        CINNAMON_DOLCE_SYRUP,
        HAZELNUT_SYRUP,
        PEPPERMINT_SYRUP,
        SUGAR_FREE_VANILLA_SYRUP,
        TOASTED_VANILLA_SYRUP,
        TOFFEE_NUT_SYRUP,
        VANILLA_SYRUP;
    }

    private Type type;
    private int quantity;

    public Syrup(Type type, int quantity) {
        super(ID);

        this.type = type;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(int quantityMin) {
        this.quantityMin = quantityMin;
    }

    public int getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(int quantityMax) {
        this.quantityMax = quantityMax;
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
        return Syrup.class.getSimpleName();
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
    public DrinkComponent newInstanceViaTypeAsString(String typeAsString, int quantity) {
        Syrup syrup = new Syrup(null, quantity);
        syrup.setTypeByString(typeAsString);
        return syrup;
    }
}
