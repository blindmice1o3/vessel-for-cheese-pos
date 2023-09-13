package com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.derived;

import android.util.Log;

import com.jackingaming.vesselforcheesepos.models.components.Incrementable;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;

import java.util.ArrayList;
import java.util.List;

public class FruitInclusion extends Fruits
        implements Incrementable {
    public static final String DEFAULT_TEXT_INIT = "Add Fruit Inclusion";
    public static final String ID = "FruitInclusion";

    public static final int DEFAULT_QUANTITY_MIN = 0;
    public static final int DEFAULT_QUANTITY_MAX = 12;

    private int quantityMin = DEFAULT_QUANTITY_MIN;
    private int quantityMax = DEFAULT_QUANTITY_MAX;

    @Override
    public void onIncrement() {
        Log.i(AddInsOptions.TAG, "start of onIncrement() --- quantity: " + quantity);

        if (quantity == QUANTITY_FOR_INVOKER) {
            Log.i(AddInsOptions.TAG, "quantity == QUANTITY_FOR_INVOKER");
            return;
        }

        quantity++;

        if (quantity > quantityMax) {
            Log.i(AddInsOptions.TAG, "quantity > quantityMax --- SETTING quantity = quantityMax");
            quantity = quantityMax;
        }
        Log.i(AddInsOptions.TAG, "end of onIncrement() --- quantity: " + quantity);
    }

    @Override
    public void onDecrement() {
        Log.i(AddInsOptions.TAG, "start of onDecrement() --- quantity: " + quantity);

        if (quantity == QUANTITY_FOR_INVOKER) {
            Log.i(AddInsOptions.TAG, "quantity == QUANTITY_FOR_INVOKER");
            return;
        }

        quantity--;

        if (quantity < quantityMin) {
            Log.i(AddInsOptions.TAG, "quantity < quantityMin --- SETTING quantity = quantityMin");
            quantity = quantityMin;
        }
        Log.i(AddInsOptions.TAG, "end of onDecrement() --- quantity: " + quantity);
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
        DRAGONFRUIT_INCLUSION,
        PINEAPPLE_INCLUSION,
        STRAWBERRY_INCLUSION;
    }

    private Type type;
    private int quantity;

    public FruitInclusion(Type type, int quantity) {
        super(ID);

        this.type = type;
        this.quantity = quantity;
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
        return FruitInclusion.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return (type == null) ? DrinkComponent.NULL_TYPE_AS_STRING : type.name();
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
        FruitInclusion fruitInclusion = new FruitInclusion(null, 1);
        fruitInclusion.setTypeByString(typeAsString);
        return fruitInclusion;
    }
}
