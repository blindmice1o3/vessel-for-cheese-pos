package com.jackingaming.vesselforcheesepos.models.components;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;

public interface Incrementable {
    int QUANTITY_FOR_INVOKER = -1;

    void onIncrement();

    void onDecrement();

    int getQuantity();

    void setQuantity(int quantity);

    DrinkComponent newInstanceViaTypeAsString(String typeAsString, int quantity);

    int getQuantityMin();
}
